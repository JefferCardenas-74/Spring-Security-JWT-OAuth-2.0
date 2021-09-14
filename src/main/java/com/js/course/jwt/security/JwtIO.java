package com.js.course.jwt.security;

import com.js.course.jwt.util.GsonUtils;
import io.fusionauth.jwt.Signer;
import io.fusionauth.jwt.Verifier;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.hmac.HMACSigner;
import io.fusionauth.jwt.hmac.HMACVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.TimeZone;

@Component
public class JwtIO {
    @Value("${jc.jwt.token.secret:secret}")
    private String SECRET;

    @Value("${jc.jwt.timezone:UTC}")
    private String TIMEZONE;

    @Value("${jc.jwt.token.expires-in:3600}")
    private int EXPIRES_IN;

    @Value("${jc.jwt.issuer:none}")
    private String ISSUER;

    public String generateToken(Object src){

        String subject = GsonUtils.serialize(src);

        //Construir HMAC signer usando el SHA-256
        Signer signer = HMACSigner.newSHA256Signer(SECRET);

        TimeZone tz = TimeZone.getTimeZone(TIMEZONE);

        ZonedDateTime zdt = ZonedDateTime.now(tz.toZoneId()).plusSeconds(EXPIRES_IN);

        JWT jwt = new JWT().setIssuer(ISSUER)
                .setIssuedAt(ZonedDateTime.now(tz.toZoneId()))
                .setSubject(subject)
                .setExpiration(zdt);

        return JWT.getEncoder().encode(jwt, signer);
    }

    public boolean validateToken(String encodeJWT){

        return false;
    }

    public String getPayload(String encodeJWT){

        return null;
    }

    private JWT jwt(String encodeJWT){

        Verifier verifer = HMACVerifier.newVerifier(SECRET);


        return JWT.getDecoder().decode(encodeJWT, verifer);
    }
}
