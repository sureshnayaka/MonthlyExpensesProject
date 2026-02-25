package com.sg.user.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.sg.user.response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(ResourceNotFoundException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        body.put("status", HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    // Handle Validation Errors (e.g., @Valid failing)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        String details = ex.getBindingResult().getFieldError().getDefaultMessage();
        ErrorResponse error = new ErrorResponse(400, "Validation Failed", details, "");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Generic fallback for any other error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobal(Exception ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Internal Server Error",
            "An unexpected error occurred", // Hide the raw stack trace from users!
            request.getDescription(false)
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNoHandlerFound(NoHandlerFoundException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", 404);
        response.put("error", "Endpoint Not Found");
        response.put("message", "The URL you requested does not exist: " + ex.getRequestURL());
        response.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}