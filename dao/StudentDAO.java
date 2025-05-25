package dao ;
import src.DBConnection;
import java.sql.*;
import java.util.*;
import model.*;




public class StudentDAO {
    public boolean registerStudent(Student s) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, s.getName());
            stmt.setInt(2, s.getAge());
            stmt.setString(3, s.getGrade());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Register error: " + e.getMessage());
            return false;
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM students";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                Student s = new Student(rs.getString("name"), rs.getInt("age"), rs.getString("grade"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Fetch error: " + e.getMessage());
        }
        return list;
    }
}
