package lk.ijse.cmjd109.jwtauthenticationproject.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JWTservice {

    private final SecretKey secretKey;

    //-----------------------Secret Key Generated--------------------------

    // "HmacSHA256" this algorithm used
    public JWTservice() {
        try {
            SecretKey k = KeyGenerator.getInstance("HmacSHA256").generateKey();
            secretKey = Keys.hmacShaKeyFor(k.getEncoded());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    // -------------------------- JWT Token Generated --------------------------

    // subject( username)
    // issuedAt( today time eka set kranwa)
    // expiration( apita kemathi widiyata time eka denna puluwan (15 minitues) )
    // signWith( api generate kragatta Secret Key eka)
    public String generateJWTToken() {
        return Jwts.builder()
                .subject("dassana")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15))
                .signWith(secretKey)
                .compact();
    }

    // ----------------------------------- Get the username on the token -----------------------------------

    public String getUserName(String token) {
        return Jwts
                .parser()
                .verifyWith(secretKey).build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}
