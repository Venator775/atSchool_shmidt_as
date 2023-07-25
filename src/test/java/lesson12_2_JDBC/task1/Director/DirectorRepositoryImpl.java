package lesson12_2_JDBC.task1.Director;

import java.sql.*;
import java.time.LocalDate;

public class DirectorRepositoryImpl implements DirectorRepository {
    private Connection connection;

    public DirectorRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public Director get(int id) {
        Director dir = null;
        try {
            PreparedStatement psSelect = connection.prepareStatement("select * from directors where id = ?");
            psSelect.setInt(1, id);

            ResultSet executionResult = psSelect.executeQuery();
            while (executionResult.next()) {
                dir = new Director(executionResult.getInt(1),
                        executionResult.getString(2),
                        executionResult.getString(3),
                        LocalDate.parse(executionResult.getString(4)),
                        executionResult.getString(5));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dir;
    }


    public void save(Director director) {

        try {
            PreparedStatement psInsert = connection.prepareStatement("insert into directors values (?,?,?,?,?)");
            psInsert.setInt(1, director.getId());
            psInsert.setString(2, director.getFirstName());
            psInsert.setString(3, director.getLastName());
            psInsert.setDate(4, Date.valueOf(director.getBirthDate()));
            psInsert.setString(5, director.getCountry());

            if (psInsert.executeUpdate()>0)
                System.out.println("|"+director+"| успешно добавлен");
        } catch (SQLException e) {
            System.out.println("Не удалось добавить |"+director+"|\n"+e.getMessage() + "\n");
        }
    }


    public void delete(Director director) {

    }


}
