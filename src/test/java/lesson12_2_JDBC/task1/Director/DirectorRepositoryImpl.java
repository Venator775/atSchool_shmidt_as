package lesson12_2_JDBC.task1.Director;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

            if (psSelect.execute()) {
                ResultSet executionResult = psSelect.getResultSet();
                while (executionResult.next()) {
                    dir = new Director(executionResult.getInt(1),
                            executionResult.getString(2),
                            executionResult.getString(3),
                            LocalDate.parse(executionResult.getString(4)),
                            executionResult.getString(5));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dir;
    }


    public void save(Director director) {

    }


    public void delete(Director director) {

    }
}
