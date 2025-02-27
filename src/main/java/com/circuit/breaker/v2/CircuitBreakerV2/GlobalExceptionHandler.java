package com.circuit.breaker.v2.CircuitBreakerV2;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CallNotPermittedException.class)
    public ResponseEntity<String> handleCallNotPermittedException(CallNotPermittedException ex) {
        return ResponseEntity.status(503).body("Service is temporarily unavailable. Please try again later.");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(500).body("Service Error: " + ex.getMessage());
    }
}
