package com.own.eosp.controller;

import com.own.eosp.model.Student;
import jakarta.validation.Valid;
import org.springframework.boot.webmvc.autoconfigure.error.BasicErrorController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class StudentController {

    @PostMapping("/save-student")
    public Student saveStudent(@Valid @RequestBody Student student) {
        // db operation
        return student;
    }
    /*
    {
        "timestamp": "2026-10-22T03:29:11.874Z",
        "status": 400,
        "error": "Bad Request",
        "trace": "org.springframework.web.bind.MethodArgumentNotValidException: Validation failed for argument [0] in public
            com.own.eosp.model.Student com.own.eosp.controller.StudentController.saveStudent(com.own.eosp.model.Student): [Field error
            in object 'student' on field 'age': rejected value [51]; codes [Range.student.age,Range.age,Range.int,Range]; arguments
            [org.springframework.context.support.DefaultMessageSourceResolvable: codes [student.age,age]; arguments [];
            MyLoggerFilter.doFilterInternal(MyLoggerFilter.java:17)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRe
            questFilter.java:116)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:107)\n\tat org.spri
            ngframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\n\tat org.springframework.web.filter.Onc
            ePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(Application
            FilterChain.java:107)\n\tat org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\n\tat org.s
            ve.java:77)\n\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:492)\n\tat
        "message": "Validation failed for object='student'. Error count: 1",
        "path": "/api/v1/save-student"
    }
    */

    @PostMapping("/save-student-v2")
    public Student saveStudentV2(@Valid @RequestBody Student student) {
        // db operation
        return student;
    }
}
