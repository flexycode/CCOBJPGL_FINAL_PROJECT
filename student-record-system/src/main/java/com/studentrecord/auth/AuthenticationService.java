package studentrecord.auth;

import studentrecord.model.User;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
    private static final Map<String, User> users = new HashMap<>();
    private final PinCodeGenerator pinCodeGenerator;
    private final QRCodeGenerator qrCodeGenerator;

    public AuthenticationService() {
        this.pinCodeGenerator = new PinCodeGenerator();
        this.qrCodeGenerator = new QRCodeGenerator();
        initializeUsers();
    }

    private void initializeUsers() {
        users.put("Admin", new User("Admin", "Admin@123", "ADMIN"));
        users.put("Student", new User("Student", "Stud321@", "STUDENT"));
    }

    public boolean authenticate(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public boolean verifyPin(String username, String pin) {
        User user = users.get(username);
        return user != null && user.getPinCode() != null && user.getPinCode().equals(pin);
    }

    public String generateNewPin(String username) {
        String pin = pinCodeGenerator.generatePin();
        User user = users.get(username);
        if (user != null) {
            user.setPinCode(pin);
        }
        return pin;
    }

    public byte[] generateQRCode(String username) {
        User user = users.get(username);
        if (user != null) {
            return qrCodeGenerator.generateQRCode(username + ":" + user.getPinCode());
        }
        return null;
    }
}
