package com.damx.security;

import java.security.SecureRandom; // i mean it's pretty secure

public class TokenGenerator {
    public static String nextToken(){
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        return bytes.toString();
    }
}
