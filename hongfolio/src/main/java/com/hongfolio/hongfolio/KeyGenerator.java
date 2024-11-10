package com.hongfolio.hongfolio;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

public class KeyGenerator {
    public static void main(String[] args) {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512); // HS512 알고리즘을 위한 키 생성
        String secretString = Encoders.BASE64.encode(key.getEncoded()); // Base64로 인코딩
        System.out.println(secretString);
    }
}