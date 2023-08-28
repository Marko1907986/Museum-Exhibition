package museumexhibition.connection;

import java.sql.*;

/**
 *
 * @author Marko Milošević, pravnik
 */
public class MyConnection {

    private static final MyConnection instance = new MyConnection();
    private Connection connection;

    private MyConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/museum_exhibition", "root", "marko");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static MyConnection getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
