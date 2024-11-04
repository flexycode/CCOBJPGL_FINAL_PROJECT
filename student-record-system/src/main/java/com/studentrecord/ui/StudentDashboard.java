package studentrecord.ui;

import studentrecord.model.Student;
import studentrecord.service.StudentService;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.Optional;

public class StudentDashboard extends JFrame {
    private final StudentService studentService;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private Image backgroundImage;
    private Image logoImage;
    private JTextField studentNoField;
    private JTextField pinCodeField;

    public StudentDashboard() {
        this.studentService = new StudentService();
        initializeUI();
        loadImages();
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
        setTitle("Student Dashboard - Student Record System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
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

        // Create table
        createTable();

        // Add components
        mainPanel.add(createHeaderPanel(), BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(studentTable), BorderLayout.CENTER);
        mainPanel.add(createInputPanel(), BorderLayout.SOUTH);
        mainPanel.add(createFooterPanel(), BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        JLabel titleLabel = new JLabel("Student Records View");
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
        studentTable.getTableHeader().setReorderingAllowed(false);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);

        JLabel studentNoLabel = new JLabel("Student No:");
        studentNoField = new JTextField(10);

        JLabel pinCodeLabel = new JLabel("PIN Code:");
        pinCodeField = new JTextField(6);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchStudent());

        panel.add(studentNoLabel);
        panel.add(studentNoField);
        panel.add(pinCodeLabel);
        panel.add(pinCodeField);
        panel.add(searchButton);

        return panel;
    }

    private void searchStudent() {
        String studentNo = studentNoField.getText().trim();
        String pinCode = pinCodeField.getText().trim();

        Optional<Student> student = studentService.getStudentByNo(studentNo);
        tableModel.setRowCount(0); // Clear previous records

        if (student.isPresent()) {
            Object[] row = {
                    student.get().getStudentNo(),
                    student.get().getName(),
                    student.get().getDepartment(),
                    student.get().getDegree()
            };
            tableModel.addRow(row);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Student No or PIN Code.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JPanel createFooterPanel() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refreshTable());

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> logout());

        panel.add(refreshButton);
        panel.add(logoutButton);

        return panel;
    }

    private void refreshTable() {
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

    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to logout?",
                "Confirm Logout",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            dispose();
            new LoginFrame().setVisible(true); // Assuming you have a LoginFrame class for login
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentDashboard dashboard = new StudentDashboard();
            dashboard.setVisible(true);
        });
    }
}