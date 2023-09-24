package com.example.demo._4_exception;

public class NoEmployeeFoundException extends RuntimeException {
    public NoEmployeeFoundException(Long id) {
        super("No such ID exist: "+id);
    }
}
