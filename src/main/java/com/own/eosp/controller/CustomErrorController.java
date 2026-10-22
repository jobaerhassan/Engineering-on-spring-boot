package com.own.eosp.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.webmvc.error.ErrorAttributes;
import org.springframework.boot.webmvc.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
@RequestMapping("/error")
public class CustomErrorController implements ErrorController { // must be implemented by ErrorController

    @Autowired
    private ErrorAttributes errorAttributes;

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody // must be used because jehetu amra mvc er jonno kono html page return kortesina so body te html dite hobe.
    public String errorHtml(HttpServletRequest request) {
        WebRequest webRequest = new ServletWebRequest(request);
        ErrorAttributeOptions options = ErrorAttributeOptions.defaults()
                .including(ErrorAttributeOptions.Include.MESSAGE,
                           ErrorAttributeOptions.Include.STACK_TRACE);
        Map<String, @Nullable Object> map = errorAttributes.getErrorAttributes(webRequest, options);
        return """
                <h1>Error occured</h1>
                timeStamp: %s <br/>
                status: %s <br/>
                message: %s <br/>
                stackTrace: %s <br/>
                """.formatted(map.get("timestamp"), map.get("status"), map.get("message"), map.get("trace"));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, @Nullable Object>> errorJson(HttpServletRequest request) {
        WebRequest webRequest = new ServletWebRequest(request);
        ErrorAttributeOptions options = ErrorAttributeOptions.defaults()
                .including(ErrorAttributeOptions.Include.MESSAGE,
                           ErrorAttributeOptions.Include.STACK_TRACE);
        Map<String, @Nullable Object> map = errorAttributes.getErrorAttributes(webRequest, options);
        Object status = map.get("status");
        HttpStatus httpStatus = (status instanceof Integer code) ? HttpStatus.valueOf(code) : HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(httpStatus).body(map);
    }
}
