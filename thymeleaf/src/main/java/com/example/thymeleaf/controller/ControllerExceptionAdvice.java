package com.example.thymeleaf.controller;

import com.example.thymeleaf.exception.TestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Класс-обработчик исключений
 *
 * @author Andrey Pomelov
 * @version 1.0-SNAPSHOT
 */
@ControllerAdvice
@ResponseBody
public class ControllerExceptionAdvice {

    @ExceptionHandler(TestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String testExceptionHandler(TestException e) {
        return e.getMessage();
    }
}
