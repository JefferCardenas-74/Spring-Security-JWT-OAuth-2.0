package com.js.course.jwt.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class Apiunathorized extends Exception{

    public Apiunathorized(String message){
        super(message);
    }

}
