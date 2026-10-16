package com.own.eosp.exceptionHandler;

import com.own.eosp.exception.AccessDeniedException;
import com.own.eosp.exception.MathException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice // this is a global exception handler for rest controllers
//@ControllerAdvice // this is a global exception handler for all controllers (mvc)
// if we have both then rest controller will be preferred but we can use separate methods to differentiate the mvc and rest controllers
// ex: @Annotation, basePackages, basePackageClasses etc
public class GlobalExceptionHandler {

    // if no exception handler is found then this will be called
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "Ex:- " + ex.getMessage();
    }
    // we can wire up multiple exception handlers
    @ExceptionHandler(MathException.class)
    public String handleMathException(MathException ex) {
        return "MathEx:- " + ex.getMessage();
    }

    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException(AccessDeniedException ex) {
        return "AccessDeniedEx:- " + ex.getMessage();
    }
}
