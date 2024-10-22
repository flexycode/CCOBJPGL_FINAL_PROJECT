package com.artificialledgersrm.gui;

import com.artificialledgersrm.service.UserService;
import com.artificialledgersrm.service.StudentService;
import com.artificialledgersrm.util.QRCodeGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents the login screen of the ArtificialLedgerSRM application.
 */
public class LoginFrame extends JFrame {
    private UserService userService;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel qrCodeLabel;

    /**
     * Constructs a new LoginFrame.
     *
     * @param userService The UserService to use for authentication
     */
    public LoginFrame(UserService userService) {
        this.userService = userService;
        initComponents();
    }

    /**
     * Initializes and arranges the GUI components.
     */
    private void initComponents() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        usernameField = new JTextField(15);
        add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(15);
        add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        JButton loginButton = new JButton("Login");
        add(loginButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        qrCodeLabel = new JLabel();
        add(qrCodeLabel, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (userService.authenticate(username, password)) {
                    String role = userService.getRole(username);
                    JOptionPane.showMessageDialog(LoginFrame.this, "Login successful! Role: " + role);

                    if ("Admin".equals(role)) {
                        new AdminFrame(new StudentService()).setVisible(true);
                    } else if ("Student".equals(role)) {
                        new StudentFrame(new StudentService()).setVisible(true);
                    }

                    LoginFrame.this.dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid credentials");
                }
            }
        });

        generateAndDisplayQRCode();
    }

    /**
     * Generates and displays the QR code for login credentials.
     */
    private void generateAndDisplayQRCode() {
        try {
            String qrContent = "Admin:Admin@123\nStudent:Stud321@";
            byte[] qrCodeImage = QRCodeGenerator.generateQRCode(qrContent, 150, 150);
            ImageIcon icon = new ImageIcon(qrCodeImage);
            qrCodeLabel.setIcon(icon);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error generating QR code");
        }
    }
}