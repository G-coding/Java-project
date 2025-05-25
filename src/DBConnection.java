package src ;
import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/school_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Anuj@5649";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connected to database");
            return conn;
        } catch (SQLException e) {
            System.out.println("❌ Database not connected: " + e.getMessage());
            return null;
        }
    }
}
