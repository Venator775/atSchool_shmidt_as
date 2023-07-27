package Shmidt.lesson12_2_JDBC.task2.Movies;

import Shmidt.lesson12_2_JDBC.task2.Director.Director;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public class MovieRepositoryImpl implements MovieRepository {
    private Connection connection;

    public MovieRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public Movie get(int id) {
        Movie movie = null;
        try {
            String query = "select m.id, m.title, m.genre, m.\"release\", m.director, d.first_name, d.last_name, d.birth_date, d.country " +
                    "from public.movies m \n" +
                    "join public.directors d on m.director = d.id " +
                    "where m.id = " + id;

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
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
                System.out.println("select: |" + movie + "| успешно найден");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return movie;
    }

    public void save(Movie movie) {
        try {
            String query = "insert into movies values (" +
                    movie.getId() + "," +
                    "\'"+movie.getTitle() + "\'," +
                    "\'"+movie.getGenre() + "\'," +
                    "\'"+movie.getRelease().toString() + "\'," +
                    movie.getDirector().getId() + ")";
            Statement statement = connection.createStatement();
            if (statement.executeUpdate(query) > 0)
                System.out.println("insert: |" + movie + "| успешно добавлен");
        } catch (SQLException e) {
            System.out.println("Не удалось добавить |" + movie + "|\n" + e.getMessage() + "\n");
        }
    }

    public void delete(Movie movie) {

    }

    public List<Movie> get(Director d) {
        return null;
    }
}
