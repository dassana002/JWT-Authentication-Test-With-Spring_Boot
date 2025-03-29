package lk.ijse.cmjd109.jwtauthenticationproject.service;

import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

@Service
@RequiredArgsConstructor
public class JWTservice {

    private final SecretKey secretKey;

    public JWTservice() {
        try {
            SecretKey k = KeyGenerator.getInstance("HmacSHA256").generateKey();
            secretKey = Keys.hmacShaKeyFor(k.getEncoded());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
