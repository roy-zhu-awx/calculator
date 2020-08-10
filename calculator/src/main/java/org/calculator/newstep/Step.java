package org.calculator.newstep;

import java.math.BigDecimal;
import java.util.Stack;

public class Step {
    private Stack<BigDecimal> numbers;

    public Step() {
        numbers=new Stack<>();
    }

    public Stack<BigDecimal> getNumbers() {
        return numbers;
    }
    public void addNumber(BigDecimal number){
        numbers.add(number);
    }
}
