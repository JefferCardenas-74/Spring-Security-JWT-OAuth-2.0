
package com.js.course.jwt.services;

import com.js.course.jwt.dto.JwtResponse;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 */

@Service
public class AuthServices {
    
    public JwtResponse login(String clientId, String clientSecret){
        
        JwtResponse jwt = JwtResponse.builder()
                .tokenType("bearer")
                .accessToken("xdxdxdxdxd")
                .issuedAt(System.currentTimeMillis() + "")
                .clientId(clientId)
                .expiresIn(3600)
                .build();
        
        return jwt;
    }
    
    public void algo(){
        System.out.println("algo apra imprimir");
    }
}
