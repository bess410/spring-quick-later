package com.example.springquick.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Data
@Service
@ApplicationScope
public class LoginCountService {

    private int count;

    public void increment() {
        count++;
    }
}
