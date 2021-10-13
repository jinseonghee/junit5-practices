package com.example.springcalculator.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // 이 annotation을 사용하면 생성자를 써줄 필요가 없다.
public class Calculator {

    private final ICalculator iCalculator; //생성자를 없애준 대신 생성자에서 주입받을 객체에 final을 사용

    /*
    public Calculator(ICalculator iCalculator) {
        this.iCalculator = iCalculator;
    }
    */

    public int sum(int x, int y) {
        this.iCalculator.init(); //서버로 부터 정보를 먼저 가져와서 계산함
        return this.iCalculator.sum(x, y);
    }

    public int minus(int x, int y) {
        this.iCalculator.init();
        return this.iCalculator.minus(x, y);
    }
}
