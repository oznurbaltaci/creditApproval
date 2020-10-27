package com.koc.finance.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class CreditPointService {

    private final Random random = new Random();
    private final int [] credits = {300,400,500,600,700,900,1000,1100,1200};

    public Integer getCreditPoint(){
        return credits[random.nextInt(credits.length)];
    }
}
