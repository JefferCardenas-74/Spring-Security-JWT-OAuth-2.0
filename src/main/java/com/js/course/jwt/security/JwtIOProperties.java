
package com.js.course.jwt.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Jeffer Cardenas <jecgdevp@gmail.com>
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "jc.jwt")
public class JwtIOProperties {
    
    private Security security;
    private String timezone;
    private String issuer;
    private Token token;
    private Excluded excluded;
    
    @Data
    public static class Security{
        private boolean enabled;
    }
    
    @Data
    public static class Token{
        
        private Auth auth;
        private String secret;
        private int expiresIn;
    }
    
    @Data
    public static class Auth{
        private String path;
    }
    
    @Data
    public static class Excluded{
        private String path;
    }
}
