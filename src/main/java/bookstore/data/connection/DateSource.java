package bookstore.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DateSource {
    private static final String URL = "jdbc:postgresql://localhost:5432/bookstore_bh";
    private static final String useName = "postgres";
    private static final String PASSWORD = "root";
    private Connection connection;

    public Connection getConnection (){

        if (connection==null){
            try {
                connection = DriverManager.getConnection(URL,useName,PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }return connection;
    }

}
