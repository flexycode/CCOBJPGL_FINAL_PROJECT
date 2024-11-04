package studentrecord.ui;

import studentrecord.auth.AuthenticationService;
import studentrecord.model.User;
import studentrecord.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.Random;

public class LoginFrame extends JFrame {
    private final AuthenticationService authService;
    private final UserService userService;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private Image backgroundImage;
    private Image logoImage;

    public LoginFrame() {
        this.authService = new AuthenticationService();
        this.userService = new UserService();
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
        setTitle("Student Record System - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Create custom panel with background
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
                if (logoImage != null) {
                    g.drawImage(logoImage, getWidth() / 2 - 85, 20, 170, 150, this);
                }
            }
        };
        mainPanel.setLayout(new GridBagLayout());

        // Create login panel
        JPanel loginPanel = createLoginPanel();
        mainPanel.add(loginPanel);

        setContentPane(mainPanel);
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Username
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        usernameField = new JTextField(20);
        panel.add(usernameField, gbc);

        // Password
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        passwordField = new JPasswordField(20);
        panel.add(passwordField, gbc);

        // Login Button
        gbc.gridx = 1; gbc.gridy = 2;
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(this::handleLoginButton);
        panel.add(loginButton, gbc);

        // QR Code Button
        gbc.gridx = 1; gbc.gridy = 3;
        JButton qrButton = new JButton("Use QR Code");
        qrButton.addActionListener(e -> showQRCodeDialog());
        panel.add(qrButton, gbc);

        return panel;
    }

    private void handleLoginButton(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Authenticate user
        if (authService.authenticate(username, password)) {
            User user = userService.getUser (username);
            if (user != null) {
                // Generate a 6-digit PIN code
                String pin = generatePinCode();

                // Show the generated PIN code
                JOptionPane.showMessageDialog(this, "Your generated PIN Code is: " + pin);

                // Prompt for PIN code verification
                String enteredPin = JOptionPane.showInputDialog(this, "Enter the 6-digit PIN code to verify:");

                // Verify the entered PIN code
                if (enteredPin != null && enteredPin.equals(pin)) {
                    // Proceed to the appropriate dashboard
                    if (userService.isAdmin(username)) {
                        openAdminDashboard();
                    } else {
                        openStudentDashboard();
                    }
                    dispose(); // Close the login frame
                } else {
                    JOptionPane.showMessageDialog(this, "Incorrect PIN! Access Denied.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String generatePinCode() {
        Random random = new Random();
        int pin = 100000 + random.nextInt(900000); // Generate a random 6-digit number
        return String.valueOf(pin);
    }

    private void openAdminDashboard() {
        new AdminDashboard().setVisible(true); // Open the admin dashboard
    }

    private void openStudentDashboard() {
        new StudentDashboard().setVisible(true); // Open the student dashboard
    }

    private void showQRCodeDialog() {
        // Logic to display QR code dialog
        JOptionPane.showMessageDialog(this, "QR Code functionality is not implemented yet.",
                "QR Code", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        });
    }
}