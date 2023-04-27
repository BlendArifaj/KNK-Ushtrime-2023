package service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordHasher {
    private static final int SALT_LENGTH = 32; // length of salt in bytes
    private static final int HASH_LENGTH = 256; // length of hash in bytes
    private static final String HASH_ALGORITHM = "SHA-256";

//    TODO: Create method that generates salt
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String generateSaltedHash(String password, String salt) {
        byte[] hash = hashWithSalt(password, salt);

        // Combine salt and hash into a single string
        StringBuilder sb = new StringBuilder(SALT_LENGTH + HASH_LENGTH);

        byte [] saltBytes = salt.getBytes();
        for (int i = 0; i < saltBytes.length; i++) {
            sb.append(String.format("%02x", saltBytes[i]));
        }
        for (int i = 0; i < hash.length; i++) {
            sb.append(String.format("%02x", hash[i]));
        }
        return sb.toString();
    }

    public static boolean compareSaltedHash(String password, String salt, String saltedHash) {
        byte[] expectedHash = new byte[HASH_LENGTH];
        for (int i = 0; i < HASH_LENGTH; i++) {
            int index = (SALT_LENGTH + i) * 2;
            expectedHash[i] = (byte) Integer.parseInt(saltedHash.substring(index, index + 2), 16);
        }
        byte[] actualHash = hashWithSalt(password, salt);
        return MessageDigest.isEqual(expectedHash, actualHash);
    }

    private static byte[] hashWithSalt(String password, String salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            digest.reset();
            digest.update(salt.getBytes());
            byte[] hash = digest.digest(password.getBytes());
            for (int i = 0; i < 1000; i++) {
                digest.reset();
                hash = digest.digest(hash);
            }
            return hash;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to hash password: " + e.getMessage(), e);
        }
    }
}