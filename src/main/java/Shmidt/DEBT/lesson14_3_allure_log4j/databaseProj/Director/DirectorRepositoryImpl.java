package Shmidt.DEBT.lesson14_3_allure_log4j.databaseProj.Director;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DirectorRepositoryImpl implements DirectorRepository {
    private Connection connection;

    private static final Logger logger = LogManager.getLogger(DirectorRepositoryImpl.class);

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

    public List<Director> getX(List<String> genres) {
        logger.info("List<Director> getX - Запрос списка режисёров по жанрам: " + genres);
        List<Director> directors = new ArrayList<>();

        //region
//        String str = genres.stream()
//                .map((s)-> "'"+s+"'")
//                .collect(Collectors.joining(", "));
//        String queryStr = "select d.id, d.first_name, d.last_name, d.birth_date, d.country  " +
//                "from public.movies m " +
//                "join public.directors d on " +
//                "m.director = d.id " +
//                "where genre in (?) " +
//                "group by d.id";
//        try {
//            PreparedStatement statementX = connection.prepareStatement(queryStr);
//            statementX.setString(1,str);
//            statementX.executeQuery();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        //endregion

        try {
            String query = "select d.id, d.first_name, d.last_name, d.birth_date, d.country  " +
                    "from public.movies m " +
                    "join public.directors d on " +
                    "m.director = d.id " +
                    "where genre in (" + genresToQueryString(genres) + ") " +
                    "group by d.id";

            directors = getAllStringsFromDB(query).stream()
                    .map(resString -> new Director(
                            (int) resString.get("id"),
                            resString.get("first_name").toString(),
                            resString.get("last_name").toString(),
                            LocalDate.parse(resString.get("birth_date").toString()),
                            resString.get("country").toString()))
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            logger.error("List<Director> getX - запуск метода. id = " + e.getMessage());
            System.out.println(e.getMessage());
        }
        logger.info("List<Director> getX - Получили список режисёров: " + directors);
        return directors;
    }

    private List<Map<String, Object>> getAllStringsFromDB(String query) {
        List<Map<String, Object>> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                String columnName;
                Map<String, Object> map = new HashMap<>();

                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    columnName = metaData.getColumnName(i);
                    Object objStr = resultSet.getObject(columnName);
                    map.put(columnName, objStr);
                }
                result.add(map);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private String genresToQueryString(List<String> genres) throws SQLException {
        if (genres == null)
            throw new SQLException("Пустой список запрашиваемых жанров");

        StringBuilder result = new StringBuilder();
        genres.forEach(genre -> {
            result.append("'").append(genre).append("'").append(", ");
        });
        result.delete(result.length() - 2, result.length());

        return result.toString();
    }
}
