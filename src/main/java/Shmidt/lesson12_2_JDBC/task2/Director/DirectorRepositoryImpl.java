package Shmidt.lesson12_2_JDBC.task2.Director;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DirectorRepositoryImpl implements DirectorRepository {
    private Connection connection;

    public DirectorRepositoryImpl(Connection connection) {
        this.connection = connection;
    }


    public Director get(int id) {
        Director director = null;
        try {
            String query = "select * from directors where id = ?";
            PreparedStatement psSelect = connection.prepareStatement(query);
            psSelect.setInt(1, id);

            ResultSet executionResult = psSelect.executeQuery();
            while (executionResult.next()) {
                director = new Director(executionResult.getInt(1),
                        executionResult.getString(2),
                        executionResult.getString(3),
                        LocalDate.parse(executionResult.getString(4)),
                        executionResult.getString(5));
                System.out.println("select: |" + director + "| успешно найден");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return director;
    }

    public Director getRandom() {
        Director director = null;
        try {
            String query = "select * from directors order by random() limit 1";
            Statement statement = connection.createStatement();
            ResultSet executionResult = statement.executeQuery(query);
            while (executionResult.next()) {
                director = new Director(executionResult.getInt("id"),
                        executionResult.getString("first_name"),
                        executionResult.getString("last_name"),
                        LocalDate.parse(executionResult.getString("birth_date")),
                        executionResult.getString("country"));
                System.out.println("select random: |" + director + "| успешно найден");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return director;
    }

    public void save(Director director) {

        try {
            String query = "insert into directors values (?,?,?,?,?)";
            PreparedStatement psInsert = connection.prepareStatement(query);
            psInsert.setInt(1, director.getId());
            psInsert.setString(2, director.getFirstName());
            psInsert.setString(3, director.getLastName());
            psInsert.setDate(4, Date.valueOf(director.getBirthDate()));
            psInsert.setString(5, director.getCountry());

            if (psInsert.executeUpdate() > 0)
                System.out.println("insert: |" + director + "| успешно добавлен");
        } catch (SQLException e) {
            System.out.println("Не удалось добавить |" + director + "|\n" + e.getMessage() + "\n");
        }
    }


    public void delete(Director director) {
        try {
            String query = "delete from directors where " +
                    "id = ? " +
                    "and first_name like ? " +
                    "and last_name like ? " +
                    "and birth_date = ? " +
                    "and country like ?";

            PreparedStatement psDelete = connection.prepareStatement(query);
            psDelete.setInt(1, director.getId());
            psDelete.setString(2, director.getFirstName());
            psDelete.setString(3, director.getLastName());
            psDelete.setDate(4, Date.valueOf(director.getBirthDate()));
            psDelete.setString(5, director.getCountry());

            if (psDelete.executeUpdate() > 0)
                System.out.println("delete: |" + director + "| успешно удалён");

        } catch (SQLException e) {
            System.out.println("Не удалось удалить |" + director + "|\n" + e.getMessage() + "\n");
        }

    }

    public List<Director> get(List<String> genres) {

        List<Director> directors = null;

        try {
            String query = "select d.id, d.first_name, d.last_name, d.birth_date, d.country  " +
                    "from public.movies m " +
                    "join public.directors d on " +
                    "m.director = d.id " +
                    "where genre in (" + genresToQueryString(genres) + ") " +
                    "group by d.id";
            Statement psGet = connection.createStatement();

            if (psGet.execute(query)) {
                directors = new ArrayList<>();
                ResultSet dirIds = psGet.getResultSet();
                while (dirIds.next()) {
                    directors.add(new Director(dirIds.getInt("id"),
                            dirIds.getString("first_name"),
                            dirIds.getString("last_name"),
                            LocalDate.parse(dirIds.getString("birth_date")),
                            dirIds.getString("country")));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return directors;
    }

    private String genresToQueryString(List<String> genres) {
        StringBuilder result = new StringBuilder();
        genres.forEach(genre -> {
            result.append("'").append(genre).append("'").append(", ");
        });
        result.delete(result.length() - 2, result.length());
        String g = result.toString();
        return result.toString();
    }
}
