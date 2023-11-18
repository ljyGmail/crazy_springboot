package com.crazyit.firstboot.ch03.controller;

import com.crazyit.firstboot.ch03.exception.BookException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackageClasses = Ch03Controller.class)
public class ErrorHandlerAdvice extends ResponseEntityExceptionHandler {

    // 定义异常处理方法
    @ExceptionHandler(BookException.class)
    public ResponseEntity<?> handle(HttpServletRequest request, Throwable ex) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.statud_code");
        if (statusCode == null) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.valueOf(statusCode));
    }
}
