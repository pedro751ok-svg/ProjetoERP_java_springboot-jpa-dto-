package com.treinando_classes.demo.Services_token_generated;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
public class TokenGenerated {
    private static final SecretKey SECRET_KEY =
    Keys.hmacShaKeyFor("LEMBRAR DE COLOCAR A SECRETE_KEY AQUI".getBytes());

    private static final long EXPIRATION_MS = 3600_00;

    public String gerarToken(String username){
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(SECRET_KEY)
                .compact ();

    }

    public String extrairUserName(String Token){
        return extrairclaims(Token).getSubject();
    }

    public Boolean ValidarToken(String Token){
        try{
            Claims claims = extrairclaims(Token);
            return !claims.getExpiration().before(new Date());
        }catch (JwtException | IllegalArgumentException e){
            return false;
        }
    }

    private Claims extrairclaims(String Token){
        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(Token)
                .getPayload();
    }
}
