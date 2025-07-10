package com.summerpep.algo;

import org.springframework.stereotype.Component;

@Component
public class MyNextPasswordHasher implements PasswordHasher{
    // Do hashing for a password
    @Override
    public String hash(String password) {
        StringBuilder ans= new StringBuilder();
        for (int i=0;i<password.length();i++) ans.append((password.charAt(i) + 1) % 256);
        return ans.toString();
    }

    // match the hash of a password with the entered password
    @Override
    public boolean match(String hash, String newPassword) {
        StringBuilder ans= new StringBuilder();
        for (int i=0;i<hash.length();i++) ans.append((hash.charAt(i) - 1) % 256);
        return ans.toString().equals(newPassword);
    }
}
