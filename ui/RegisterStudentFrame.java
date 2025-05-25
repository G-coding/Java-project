package ui ;
import javax.swing.*;
import java.awt.*;
import model.Student;
import dao.StudentDAO;
public class RegisterStudentFrame extends JFrame {
    public RegisterStudentFrame() {
        setTitle("Register Student");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Register New Student", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField gradeField = new JTextField();

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Grade:"));
        panel.add(gradeField);

        JButton registerBtn = new JButton("Register");
        panel.add(registerBtn);

        add(panel, BorderLayout.CENTER);

        registerBtn.addActionListener(e -> {
            Student student = new Student(nameField.getText(), Integer.parseInt(ageField.getText()), gradeField.getText());
            if (new StudentDAO().registerStudent(student)) {
                JOptionPane.showMessageDialog(this, "Student Registered!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to register");
            }
        });

        setVisible(true);
    }
}

