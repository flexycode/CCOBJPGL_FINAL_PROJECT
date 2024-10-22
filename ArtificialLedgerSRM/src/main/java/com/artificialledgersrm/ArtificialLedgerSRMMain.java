package com.artificialledgersrm;

import com.artificialledgersrm.gui.LoginFrame;
import com.artificialledgersrm.service.UserService;

import javax.swing.*;

/**
 * Main class for the ArtificialLedgerSRM application.
 * This class is responsible for initializing the application and launching the GUI.
 */
public class ArtificialLedgerSRMMain {

    /**
     * The entry point of the application.
     * Creates an instance of UserService and launches the LoginFrame on the Event Dispatch Thread.
     *
     * @param args Command line arguments (not used in this application)
     */
    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure that the GUI is created and updated on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            // Create an instance of UserService
            UserService userService = new UserService();

            // Create and display the LoginFrame
            LoginFrame loginFrame = new LoginFrame(userService);
            loginFrame.setVisible(true);
        });
    }
}