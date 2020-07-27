package com.springdemo.jwtdemo.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/26 16:34
 * @Version 1.0
 **/
public class JwtUtils {

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    public static String getToken(String username,String password){
        //认定已经验证成功
        return "token"+username+password;
    }


    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, "secret")
                .compact();
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + 604800 * 1000);
    }

    public static void main(String[] args) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, "useradmin");
        claims.put(CLAIM_KEY_CREATED, new Date());
        System.out.println(new JwtUtils().generateToken(claims));
    }
}
