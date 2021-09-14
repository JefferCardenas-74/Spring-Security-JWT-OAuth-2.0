
package com.js.course.jwt.services;

import com.js.course.jwt.dto.JwtResponse;
import com.js.course.jwt.security.JwtIO;
import com.js.course.jwt.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 */

@Service
public class AuthServices {

    @Autowired
    private JwtIO jwtIO;

    @Autowired
    private DateUtils dateUtils;

    @Value("${jc.jwt.token.expires-in}")
    private int EXPIRES_IN;
    
    public JwtResponse login(String clientId, String clientSecret){
        
        JwtResponse jwt = JwtResponse.builder()
                .tokenType("bearer")
                .accessToken(jwtIO.generateToken("hola mundo desde AuthService"))
                .issuedAt(dateUtils.getDateMillis() + "")
                .clientId(clientId)
                .expiresIn(EXPIRES_IN)
                .build();
        
        return jwt;
    }
}
