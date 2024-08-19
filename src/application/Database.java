package application;

import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

    private static final Logger logger = Logger.getLogger(Database.class.getName());

    public int insert(String user, String pass) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/CRM";
        String dbUsername = "root";
        String dbPassword = "malupavi@0925";
        String sql = "INSERT INTO Login (username, password) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(java.util.logging.Level.SEVERE, "Error during insertion", e);
            e.printStackTrace();
            // return -1 in case of an error
            return -1;
        }
    }
    public int insert1(String product_id, String product_name,String description,String feedback,String customer_id) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/CRM";
        String dbUsername = "root";
        String dbPassword = "malupavi@0925";
        String sql1 = "INSERT INTO product (product_id, product_name,description,feedback,customer_id) VALUES (?, ? , ? , ? , ? )";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(sql1)) {
            preparedStatement.setString(1, product_id);
            preparedStatement.setString(2, product_name);
            preparedStatement.setString(3, description);
            preparedStatement.setString(4, feedback);
            preparedStatement.setString(5, customer_id);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(java.util.logging.Level.SEVERE, "Error during insertion", e);
            e.printStackTrace();

            return -1;
        }
    }
}
