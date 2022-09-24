package com.example.springquick.proxy;

import com.example.springquick.dto.Payment;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Data
@Component
public class PaymentsProxy {

    private final WebClient webClient;

    @Value("${name.service.url}")
    private String paymentsServiceUrl;

    public Mono<Payment> createPayment(
            String requestId,
            Payment payment) {

        return webClient.post()
                .uri(paymentsServiceUrl + "/payment")
                .header("requestId", requestId)
                .body(Mono.just(payment), Payment.class)
                .retrieve()
                .bodyToMono(Payment.class);
    }
}
