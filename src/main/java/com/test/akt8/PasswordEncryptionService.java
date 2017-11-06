/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.akt8;


import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 *
 * @author User
 */
public class PasswordEncryptionService {
    
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 1024;

    
    //метод получения хешированного пароля
    public static String hashPassword(String password, String salt) {
        char[] passwordChars = password.toCharArray();
        byte[] saltBytes = salt.getBytes();

        PBEKeySpec spec = new PBEKeySpec(passwordChars, saltBytes, ITERATIONS, KEY_LENGTH);
        SecretKeyFactory key;
        byte[] hashedPassword = null;

        try {
            key = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            hashedPassword = key.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return toHex(hashedPassword);
    }

//Генерация соли
    public static String generateSalt() {
        byte[] salt = new byte[32];
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.nextBytes(salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return toHex(salt);
    }

    
    private static String toHex(byte[] array) {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }
    
}
