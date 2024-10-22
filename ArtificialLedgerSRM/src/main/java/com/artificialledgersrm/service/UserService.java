package com.artificialledgersrm.service;

import com.artificialledgersrm.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Service class for managing user authentication and role retrieval.
 */
public class UserService {
    private final Map<String, User> users;

    /**
     * Initializes the UserService with predefined users.
     */
    public UserService() {
        users = new HashMap<>();
        users.put("Admin", new User("Admin", "Admin@123", "Admin"));
        users.put("Student", new User("Student", "Stud321@", "Student"));
    }

    /**
     * Authenticates a user based on the provided username and password.
     *
     * @param username The username to authenticate
     * @param password The password to verify
     * @return true if authentication is successful, false otherwise
     */
    public boolean authenticate(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    /**
     * Retrieves the role of a user based on their username.
     *
     * @param username The username to look up
     * @return The role of the user, or null if the user is not found
     */
    public String getRole(String username) {
        User user = users.get(username);
        return user != null ? user.getRole() : null;
    }
}
