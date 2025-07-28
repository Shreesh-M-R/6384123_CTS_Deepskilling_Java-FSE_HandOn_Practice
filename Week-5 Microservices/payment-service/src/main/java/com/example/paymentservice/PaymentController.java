package com.example.paymentservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final WebClient webClient;

    public PaymentController(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://httpstat.us/200?sleep=5000").build();
    }

    @GetMapping("/process")
    @CircuitBreaker(name = "paymentCB", fallbackMethod = "fallbackPayment")
    public Mono<String> processPayment() {
        return webClient.get().retrieve().bodyToMono(String.class);
    }

    public Mono<String> fallbackPayment(Throwable t) {
        return Mono.just("Fallback response: Payment system is busy, try again later.");
    }
}
