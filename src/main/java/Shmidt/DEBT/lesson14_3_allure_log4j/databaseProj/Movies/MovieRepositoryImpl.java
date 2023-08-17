package Shmidt.DEBT.lesson14_3_allure_log4j.databaseProj.Movies;

import Shmidt.DEBT.lesson14_3_allure_log4j.databaseProj.Director.Director;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class MovieRepositoryImpl{
    private Connection connection;

    private static final Logger logger = LogManager.getLogger(MovieRepositoryImpl.class);

    public MovieRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public Movie get(int id) {
        logger.debug("Movie get() - запуск метода. id = " + id);
        Movie movie = null;
        try {
            String query = "select m.id, m.title, m.genre, m.\"release\", m.director, d.first_name, d.last_name, d.birth_date, d.country " +
                    "from public.movies m " +
                    "join public.directors d on m.director = d.id " +
                    "where m.id = " + id;

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                logger.debug("Movie get() - выполнили SQL запрос: |" + query + "|");
                movie = new Movie(result.getInt("id"),
                        result.getString("title"),
                        result.getString("genre"),
                        LocalDate.parse(result.getString("release")),
                        new Director(result.getInt("director"),
                                result.getString("first_name"),
                                result.getString("last_name"),
                                LocalDate.parse(result.getString("birth_date")),
                                result.getString("country"))
                );
                logger.info("Movie get() - select: |" + movie + "| успешно найден");
            }
        } catch (SQLException e) {
            logger.error("Movie get() - " + e.getMessage());
        }
        return movie;
    }

    public void save(Movie movie) {
        logger.debug("void save() - запуск метода. movie = " + movie);
        try {
            Statement statement = connection.createStatement();
            String query = "insert into movies values (" +
                    movie.getId() + "," +
                    "'" + movie.getTitle() + "'," +
                    "'" + movie.getGenre() + "'," +
                    "'" + movie.getRelease().toString() + "'," +
                    movie.getDirector().getId() + ")";

            if (statement.executeUpdate(query) > 0){
                logger.debug("void save() - выполнили SQL запрос: |" + query + "|");
                logger.info("void save() - insert: |" + movie + "| успешно добавлен");
            }

        } catch (SQLException e) {
            logger.error("void save() - Не удалось добавить |" + movie + "|\n" + e.getMessage());
        }
    }

    public void delete(Movie movie) {
        logger.debug("void delete() - запуск метода. movie = " + movie);
        try {
            Statement statement = connection.createStatement();
            String query = "delete from movies where id = " + movie.getId();

            if (statement.executeUpdate(query) > 0)
                logger.info("void delete()  - delete: |" + movie + "| успешно удалён");

        } catch (SQLException e) {
            logger.error("void delete()  - Не удалось удалить |" + movie + "|\n" + e.getMessage());
        }
    }

}
