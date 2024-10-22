package com.artificialledgersrm.gui;

import com.artificialledgersrm.model.Student;
import com.artificialledgersrm.service.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentFrame extends JFrame {
    private StudentService studentService;
    private JTextField studentNoField;
    private JTextArea studentInfoArea;

    public StudentFrame(StudentService studentService) {
        this.studentService = studentService;
        initComponents();
    }

    private void initComponents() {
        setTitle("Student Panel");
        setSize(400, 300);
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
        gbc.gridwidth = 2;
        JButton viewButton = new JButton("View Student Info");
        add(viewButton, gbc);

        gbc.gridy = 2;
        gbc.gridheight = 2;
        studentInfoArea = new JTextArea(10, 30);
        studentInfoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(studentInfoArea);
        add(scrollPane, gbc);

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewStudentInfo();
            }
        });
    }

    private void viewStudentInfo() {
        String studentNo = studentNoField.getText();
        if (studentNo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Student No.");
            return;
        }

        Student student = studentService.getStudentByNo(studentNo);
        if (student == null) {
            JOptionPane.showMessageDialog(this, "Student not found.");
            return;
        }

        studentInfoArea.setText(String.format("Student No: %s\nName: %s\nDepartment: %s\nDegree: %s",
                student.getStudentNo(), student.getName(), student.getDepartment(), student.getDegree()));
    }
}
