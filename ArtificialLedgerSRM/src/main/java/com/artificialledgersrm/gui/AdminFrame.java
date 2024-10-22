package com.artificialledgersrm.gui;

import com.artificialledgersrm.model.Student;
import com.artificialledgersrm.service.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents the admin panel of the ArtificialLedgerSRM application.
 */
public class AdminFrame extends JFrame {
    private final StudentService studentService;
    private JTextField studentNoField, departmentField, degreeField, nameField;
    private JTextArea studentListArea;

    /**
     * Constructs a new AdminFrame.
     *
     * @param studentService The StudentService to use for managing student records
     */
    public AdminFrame(StudentService studentService) {
        this.studentService = studentService;
        initComponents();
    }

    /**
     * Initializes and arranges the GUI components.
     */
    private void initComponents() {
        setTitle("Admin Panel");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        add(new JLabel("Student No:"), gbc);

        gbc.gridx = 1;
        studentNoField = new JTextField(15);
        add(studentNoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Department:"), gbc);

        gbc.gridx = 1;
        departmentField = new JTextField(15);
        add(departmentField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Degree:"), gbc);

        gbc.gridx = 1;
        degreeField = new JTextField(15);
        add(degreeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        nameField = new JTextField(15);
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JButton addButton = new JButton("Add Student");
        add(addButton, gbc);

        gbc.gridy = 5;
        JButton viewButton = new JButton("View All Students");
        add(viewButton, gbc);

        gbc.gridy = 6;
        gbc.gridheight = 2;
        studentListArea = new JTextArea(10, 30);
        studentListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(studentListArea);
        add(scrollPane, gbc);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAllStudents();
            }
        });
    }

    private void addStudent() {
        String studentNo = studentNoField.getText();
        String department = departmentField.getText();
        String degree = degreeField.getText();
        String name = nameField.getText();

        if (studentNo.isEmpty() || department.isEmpty() || degree.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required");
            return;
        }

        Student student = new Student(studentNo, department, degree, name);
        studentService.addStudent(student);
        JOptionPane.showMessageDialog(this, "Student added successfully");
        clearFields();
    }

    private void viewAllStudents() {
        studentListArea.setText("");
        for (Student student : studentService.getAllStudents()) {
            studentListArea.append(String.format("Student No: %s, Name: %s, Department: %s, Degree: %s\n",
                    student.getStudentNo(), student.getName(), student.getDepartment(), student.getDegree()));
        }
    }

    private void clearFields() {
        studentNoField.setText("");
        departmentField.setText("");
        degreeField.setText("");
        nameField.setText("");
    }
}