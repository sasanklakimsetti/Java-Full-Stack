package com.summerpep.algo;

public interface PasswordHasher {
    public String hash(String password);
    public boolean match(String hash, String newPassword);
}
