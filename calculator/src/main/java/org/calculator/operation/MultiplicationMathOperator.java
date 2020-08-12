package org.calculator.operation;

import java.math.BigDecimal;
import java.util.Stack;

public class MultiplicationMathOperator implements Operation{

    @Override
    public BigDecimal operate(Stack<BigDecimal> numbers) {
        return numbers.pop().multiply(numbers.pop());
    }

    @Override
    public int getNumberNum() {
        return 2;
    }
}
