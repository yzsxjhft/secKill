package com.ywq.secKill.util;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ywq.secKill.exception.TokenExpireException;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

public class TokenUtil {
    private static String SHA_KEY = "eWry3JLVcpFaQcFL";
    private static Long ONE_DAY = 21*60*60L;
    private static Long ONE_HOUR = 60*60L;

    public static Boolean checkToken(String token) throws Exception {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SHA_KEY)).build();

        try {
            verifier.verify(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static String generateToken(String userId) throws UnsupportedEncodingException {
        Long issueAt = new Date().getTime();
        Long expireAt = issueAt + ONE_HOUR;
        String token = JWT.create()
                .withSubject(userId)
                .withIssuedAt(new Date(issueAt))
                .withExpiresAt(new Date(expireAt))
                .sign(Algorithm.HMAC256(SHA_KEY));
        return token;
    }
}
