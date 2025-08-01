package com.example;

public class UserService {
    
    private static final int MIN_USERNAME_LENGTH = 5;
    private static final String VALID_CHARS_PATTERN = "[a-zA-Z0-9_]+";
    
    public boolean isValidUsername(String username) {
        if (username == null) {
            return false;
        }
        
        boolean hasMinLength = username.length() >= MIN_USERNAME_LENGTH;
        boolean matchesPattern = username.matches(VALID_CHARS_PATTERN);
        
        return hasMinLength && matchesPattern;
    }

    public void disconnect() {
        System.out.println("Disconnected from UserService.");
    }
}
