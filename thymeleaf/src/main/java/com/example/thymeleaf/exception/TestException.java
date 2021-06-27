package com.example.thymeleaf.exception;

/** Класс-тестовый эксепшен для демонстрационных целей
 *
 * @author Andrey Pomelov
 * @version 1.0-SNAPSHOT
 */
public class TestException extends RuntimeException {

    private final String message = "This is a test exception!";

    @Override
    public String getMessage() {
        return message;
    }
}
