package ui ;
import model.Student;
import dao.StudentDAO;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewStudentFrame extends JFrame {
    public ViewStudentFrame() {
        setTitle("All Students");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextArea area = new JTextArea();
        area.setFont(new Font("Monospaced", Font.PLAIN, 14));
        area.setEditable(false);

        List<Student> list = new StudentDAO().getAllStudents();
        StringBuilder sb = new StringBuilder("Name\tAge\tGrade\n----------------------\n");
        for (Student s : list) {
            sb.append(s.getName()).append("\t").append(s.getAge()).append("\t").append(s.getGrade()).append("\n");
        }
        area.setText(sb.toString());

        add(new JScrollPane(area));
        setVisible(true);
    }
}
