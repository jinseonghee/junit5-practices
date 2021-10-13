package com.example.springcalculator.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component //spring에 의해 bean으로 관리
@RequiredArgsConstructor
public class DollarCalculator implements ICalculator {

    private int price = 1;
    private final MarketApi marketApi;

    /*
    public DollarCalculator(MarketApi marketApi) {
        this.marketApi = marketApi;
    }
    */

    @Override
    public void init() {
        this.price = marketApi.connect();
    }

    @Override
    public int sum(int x, int y) {
        x *= price;
        y *= price;
        return x + y;
    }

    @Override
    public int minus(int x, int y) {
        x *= price;
        y *= price;
        return x - y;
    }
}
