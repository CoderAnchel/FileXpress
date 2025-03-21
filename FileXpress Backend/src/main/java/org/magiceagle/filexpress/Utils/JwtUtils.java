package org.magiceagle.filexpress.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static final String SECRET_KEY = "ThisISAVERYsecretKeyithastobesoolongsooanyonecanhaveaccesitsbuildidtobesosecuethatcannotberusesinaniplace1232130913201989412";

    public static String createJWT(long ttlMillis, Map<String, Object> claims) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(nowMillis + ttlMillis))
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static Claims decodeJWT(String jwt) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }

}
