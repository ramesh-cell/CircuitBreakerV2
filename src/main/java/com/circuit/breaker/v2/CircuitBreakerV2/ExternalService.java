package com.circuit.breaker.v2.CircuitBreakerV2;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;

@Service
public class ExternalService {

    @CircuitBreaker(name = "myService")
    public String fetchData() {
        try {
            if (Math.random() > 0.5) {
                throw new RuntimeException("Service is Down!");
            }
            return "Response from External Service";
        } catch (CallNotPermittedException ex) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Circuit Breaker Open", ex);
        }
    }
}
