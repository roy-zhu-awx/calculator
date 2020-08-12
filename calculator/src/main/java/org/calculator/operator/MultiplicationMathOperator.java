package org.calculator.operator;

import java.math.BigDecimal;
import java.util.Stack;

public class MultiplicationMathOperator implements Operator {

    @Override
    public BigDecimal operate(Stack<BigDecimal> numbers) {
        return numbers.pop().multiply(numbers.pop());
    }

    @Override
    public int getNumberNum() {
        return 2;
    }
}
