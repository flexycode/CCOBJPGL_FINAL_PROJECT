package com.artificialledgersrm.model;

/**
 * Represents a user in the ArtificialLedgerSRM system.
 * This class encapsulates user information including username, password, and role.
 */
public class User {
    private String username;
    private String password;
    private String role;

    /**
     * Constructs a new User with the specified details.
     *
     * @param username The user's username
     * @param password The user's password
     * @param role     The user's role (e.g., "Admin" or "Student")
     */
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * @return The user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return The user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return The user's role
     */
    public String getRole() {
        return role;
    }
}