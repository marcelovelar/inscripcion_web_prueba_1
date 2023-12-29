package com.inscripcionweb.web.controller;

import com.inscripcionweb.exception.LockedExceptionResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.LockedException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LockedException.class)
    public ResponseEntity<LockedExceptionResponse> handleLockedException(LockedException ex) {
        LockedExceptionResponse response = new LockedExceptionResponse(ex.getMessage());
        return ResponseEntity.status(HttpStatus.LOCKED).body(response);
    }
}
