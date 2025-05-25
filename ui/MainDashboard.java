package ui;

import javax.swing.*;
import ui.RegisterStudentFrame;
import ui.ViewStudentFrame;
public class MainDashboard extends JFrame {
    public MainDashboard() {
        setTitle("School Management Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton studentBtn = new JButton("Manage Students");
        studentBtn.setBounds(100, 50, 200, 40);
        add(studentBtn);

        JButton teacherBtn = new JButton("Manage Teachers");
        teacherBtn.setBounds(100, 110, 200, 40);
        add(teacherBtn);

        studentBtn.addActionListener(e -> {
            new ViewStudentFrame();
        });

        teacherBtn.addActionListener(e -> {
            new TeacherFrame();
        });

        setVisible(true);
    }
}
