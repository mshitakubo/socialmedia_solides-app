package com.socialmedia_solides.picturessrv.resources.exceptions;


import com.socialmedia_solides.picturessrv.services.exceptions.EntityNotFoundException;
import com.socialmedia_solides.picturessrv.services.exceptions.ForbiddenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest httpServletRequest) {
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Resource not found");
        error.setMessage(e.getMessage());
        error.setPath(httpServletRequest.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<StandardError> entityNotFound(ForbiddenException e, HttpServletRequest httpServletRequest) {
        StandardError error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("forbidden");
        error.setMessage(e.getMessage());
        error.setPath(httpServletRequest.getRequestURI());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);

    }
}
