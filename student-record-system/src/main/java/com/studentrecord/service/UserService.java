package studentrecord.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import studentrecord.model.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    private static final String FILE_PATH = "users.json";
    private Map<String, User> users;

    public UserService() {
        users = loadUsers();
        if (users.isEmpty()) {
            initializeUsers();
        }
    }

    private void initializeUsers() {
        users.put("Admin", new User("Admin", "Admin@123", "ADMIN"));
        users.put("Student", new User("Student", "Stud321@", "STUDENT"));
        saveUsers();
    }

    public User getUser (String username) {
        return users.get(username);
    }

    public boolean isAdmin(String username) {
        User user = users.get(username);
        return user != null && "ADMIN".equals(user.getRole());
    }

    private Map<String, User> loadUsers() {
        try {
            if (Files.exists(Paths.get(FILE_PATH))) {
                Reader reader = new FileReader(FILE_PATH);
                return new Gson().fromJson(reader, new TypeToken<Map<String, User>>() {}.getType());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    private void saveUsers() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            new Gson().toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}