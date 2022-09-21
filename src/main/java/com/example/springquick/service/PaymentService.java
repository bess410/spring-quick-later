package com.example.springquick.service;

import com.example.springquick.dto.PaymentDetails;
import com.example.springquick.exception.NotEnoughMoneyException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
