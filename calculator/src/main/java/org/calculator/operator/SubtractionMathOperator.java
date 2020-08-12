package org.calculator.operator;

import java.math.BigDecimal;
import java.util.Stack;

public class SubtractionMathOperator implements Operator {

    @Override
    public BigDecimal operate(Stack<BigDecimal> numbers) {
        return numbers.pop().subtract(numbers.pop());
    }

    @Override
    public int getNumberNum() {
        return 2;
    }
}
