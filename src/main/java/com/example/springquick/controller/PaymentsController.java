package com.example.springquick.controller;

import com.example.springquick.dto.Payment;
import com.example.springquick.proxy.PaymentsProxy;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
public class PaymentsController {

    private final PaymentsProxy paymentsProxy;

    @PostMapping("/payment")
    public Payment createPayment(
            @RequestBody Payment payment
    ) {
        return paymentsProxy.createPayment(payment);
    }
}
