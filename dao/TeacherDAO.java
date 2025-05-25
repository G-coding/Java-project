package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Teacher;
import src.DBConnection;
public class TeacherDAO {
    public boolean addTeacher(Teacher teacher) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO teachers (name, subject) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, teacher.getName());
            stmt.setString(2, teacher.getSubject());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Add teacher error: " + e.getMessage());
            return false;
        }
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM teachers";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                    list.add(new Teacher(rs.getInt("id"), rs.getString("name"), rs.getString("subject")));
                }
            } catch (SQLException e) {
                System.out.println("Fetch teacher error: " + e.getMessage());
        }
        return list;
    }
}
