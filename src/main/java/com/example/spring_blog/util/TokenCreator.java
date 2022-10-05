package com.example.spring_blog.util;

import java.util.UUID;

public class TokenCreator {
    public static String makeToken(){
        UUID uuid = UUID.randomUUID();
        String code[] = String.valueOf(uuid).split("-");
        return code[0];
    }
}
