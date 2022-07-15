package com.system.cheker.advice;


import com.system.cheker.exception.CustomerExseption;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class CustomerControllerAdvice {

    @ExceptionHandler(value = {CustomerExseption.class})
    public ErorDidails exceptionHandler(Exception e){
        return new ErorDidails("WORNING : " , e.getMessage());
    }
}
