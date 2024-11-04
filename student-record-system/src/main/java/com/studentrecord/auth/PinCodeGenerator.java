package studentrecord.auth;

import java.security.SecureRandom;

/**
 * Utility class for generating One-Time Passwords (OTPs).
 */
public class PinCodeGenerator {
    private static final SecureRandom random = new SecureRandom();
    private static final String OTP_CHARS = "0123456789";
    private static final int OTP_LENGTH = 6;

    /**
     * Generates a random OTP of specified length.
     * @return A string representing the generated OTP
     */
    public static String generateOTP() {
        StringBuilder otp = new StringBuilder(OTP_LENGTH);
        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(OTP_CHARS.charAt(random.nextInt(OTP_CHARS.length())));
        }
        return otp.toString();
    }

    public String generatePin() {
        return generateOTP(); // Use the same logic to generate a 6-digit PIN
    }
}

