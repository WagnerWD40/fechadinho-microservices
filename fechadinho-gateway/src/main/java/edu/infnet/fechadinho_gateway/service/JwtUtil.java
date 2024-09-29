package edu.infnet.fechadinho_gateway.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtUtil {

    @Value("${jwt.secret}")
    private String JWT_SECRET;

    public String decodeToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);

        token = token.replace("Bearer ", "").strip();

        JWTVerifier verifier = JWT
                                .require(algorithm)
                                .withIssuer("fechadinho.com.br")
                                .build();

        DecodedJWT verifiedToken = verifier.verify(token);

        return verifiedToken.getSubject();
    }
}
