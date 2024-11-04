package studentrecord.ui;

import studentrecord.model.Student;
import studentrecord.service.StudentService;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.util.List;

public class AdminDashboard extends JFrame {
    private final StudentService studentService;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private Image backgroundImage;
    private Image logoImage;

    public AdminDashboard() {
        this.studentService = new StudentService();
        initializeUI();
        loadImages();
        refreshTable();
    }

    private void loadImages() {
        try {
            backgroundImage = ImageIO.read(new File("src/main/resources/images/background.jpg"));
            logoImage = ImageIO.read(new File("src/main/resources/images/logo.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeUI() {
        setTitle("Admin Dashboard - Student Record System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        // Main panel with background
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
                if (logoImage != null) {
                    g.drawImage(logoImage, 10, 10, 50, 50, this);
                }
            }
        };
        mainPanel.setLayout(new BorderLayout());

        // Create components
        createTable();
        mainPanel.add(createHeaderPanel(), BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(studentTable), BorderLayout.CENTER);
        mainPanel.add(createButtonPanel(), BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        JLabel titleLabel = new JLabel("Student Records Management");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(titleLabel);
        return panel;
    }

    private void createTable() {
        String[] columns = {"Student No", "Name", "Department", "Degree"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        studentTable = new JTable(tableModel);
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);

        JButton addButton = new JButton("Add Student");
        JButton updateButton = new JButton("Update Student");
        JButton deleteButton = new JButton("Delete Student");
        JButton refreshButton = new JButton("Refresh");
        JButton logoutButton = new JButton("Logout");

        addButton.addActionListener(e -> showAddStudentDialog());
        updateButton.addActionListener(e -> showUpdateStudentDialog());
        deleteButton.addActionListener(e -> deleteStudent());
        refreshButton.addActionListener(e -> refreshTable());
        logoutButton.addActionListener(e -> logout());

        panel.add(addButton);
        panel .add(updateButton);
        panel.add(deleteButton);
        panel.add(refreshButton);
        panel.add(logoutButton);

        return panel;
    }

    private void refreshTable() {
        // Clear the current table and load all students
        tableModel.setRowCount(0);
        List<Student> students = studentService.getAllStudents();
        for (Student student : students) {
            Object[] row = {
                    student.getStudentNo(),
                    student.getName(),
                    student.getDepartment(),
                    student.getDegree()
            };
            tableModel.addRow(row);
        }
    }

    private void showAddStudentDialog() {
        // Show dialog for adding a new student
        JDialog dialog = new JDialog(this, "Add New Student", true);
        dialog.setLayout(new GridLayout(5, 2));

        JTextField studentNoField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField departmentField = new JTextField();
        JTextField degreeField = new JTextField();

        dialog.add(new JLabel("Student No:"));
        dialog.add(studentNoField);
        dialog.add(new JLabel("Name:"));
        dialog.add(nameField);
        dialog.add(new JLabel("Department:"));
        dialog.add(departmentField);
        dialog.add(new JLabel("Degree:"));
        dialog.add(degreeField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            Student student = new Student(
                    studentNoField.getText(),
                    departmentField.getText(),
                    degreeField.getText(),
                    nameField.getText()
            );
            studentService.addStudent(student);
            refreshTable();
            dialog.dispose();
        });

        dialog.add(saveButton);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void showUpdateStudentDialog() {
        // Show dialog for updating an existing student
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a student to update");
            return;
        }

        String studentNo = (String) tableModel.getValueAt(selectedRow, 0);
        Student student = studentService.getStudentByNo(studentNo).orElse(null);
        if (student == null) return;

        JDialog dialog = new JDialog(this, "Update Student", true);
        dialog.setLayout(new GridLayout(5, 2));

        JTextField nameField = new JTextField(student.getName());
        JTextField departmentField = new JTextField(student.getDepartment());
        JTextField degreeField = new JTextField(student.getDegree());

        dialog.add(new JLabel("Student No:"));
        dialog.add(new JLabel(student.getStudentNo()));
        dialog.add(new JLabel("Name:"));
        dialog.add(nameField);
        dialog.add(new JLabel("Department:"));
        dialog.add(departmentField);
        dialog.add(new JLabel("Degree:"));
        dialog.add(degreeField);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(e -> {
            Student updatedStudent = new Student(
                    student.getStudentNo(),
                    departmentField.getText(),
                    degreeField.getText(),
                    nameField.getText()
            );
            studentService.updateStudent(updatedStudent);
            refreshTable();
            dialog.dispose();
        });

        dialog.add(updateButton);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void deleteStudent() {
        // Delete the selected student
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a student to delete");
            return;
        }

        String studentNo = (String) tableModel.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete student " + studentNo + "?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            studentService.deleteStudent(studentNo);
            refreshTable();
        }
    }

    private void logout() {
        // Dispose of the AdminDashboard and open the LoginFrame
        dispose();
        new LoginFrame().setVisible(true);
    }
}