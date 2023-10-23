package getwell.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import getwell.api.domain.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String createToken(User user) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API GetWell")
                    .withSubject(user.getLogin())
                    .withClaim("id", user.getId())
                    .withExpiresAt(expirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Error on create JWT token", exception);
        }
    }

    //Method for JWT Token validation
    public String getSubject(String tokenJTW) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return String.valueOf(JWT.require(algorithm)
                    .withIssuer("API GetWell")
                    .build()
                    .verify(tokenJTW)
                    .getSubject());
        } catch (JWTVerificationException exception){
            throw new RuntimeException("JWT Token invalid or expired!");
        }
    }

    private Instant expirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("+02:00"));
    }

}
