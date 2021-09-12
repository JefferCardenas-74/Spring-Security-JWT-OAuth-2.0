package com.js.course.jwt.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jeffer Cardenas <jecgdevp@gmail.com'>
 */
@RestController
@RequestMapping(path = "v1.0")
public class AuthController {
    
    @PostMapping(path = "oauth/client_credential/accesstoken" , consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> login(@RequestBody MultiValueMap<String, String> paramMap){
        
        return ResponseEntity.ok().build();
    }
}
