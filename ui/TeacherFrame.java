package ui;

// ui/TeacherFrame.java

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import model.Teacher;
import dao.TeacherDAO;

public class TeacherFrame extends JFrame {
    private JTextField nameField;
    private JTextField subjectField;
    private JTable teacherTable;
    private DefaultTableModel tableModel;

    public TeacherFrame() {
        setTitle("Manage Teachers");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header
        JLabel header = new JLabel("Add Teacher", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        add(header, BorderLayout.NORTH);

        // Input form
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 30));

        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Subject:"));
        subjectField = new JTextField();
        formPanel.add(subjectField);

        JButton addBtn = new JButton("Add Teacher");
        formPanel.add(addBtn);

        add(formPanel, BorderLayout.WEST);

        // Table on right side
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Subject"}, 0);
        teacherTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(teacherTable);
        add(scrollPane, BorderLayout.CENTER);

        // Load teachers
        loadTeachers();

        // Button action
        addBtn.addActionListener(e -> {
            String name = nameField.getText();
            String subject = subjectField.getText();
            if (name.isEmpty() || subject.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required!");
                return;
            }

            Teacher teacher = new Teacher(name, subject);
            if (new TeacherDAO().addTeacher(teacher)) {
                JOptionPane.showMessageDialog(this, "Teacher added successfully!");
                loadTeachers();
                nameField.setText("");
                subjectField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Error adding teacher.");
            }
        });

        setVisible(true);
    }

    private void loadTeachers() {
        List<Teacher> teachers = new TeacherDAO().getAllTeachers();
        tableModel.setRowCount(0); // Clear table
        for (Teacher t : teachers) {
            tableModel.addRow(new Object[]{t.getId(), t.getName(), t.getSubject()});
        }
    }
}

