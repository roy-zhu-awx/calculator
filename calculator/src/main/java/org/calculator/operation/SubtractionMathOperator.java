package org.calculator.operation;

import java.math.BigDecimal;
import java.util.Stack;

public class SubtractionMathOperator implements Operation{

    @Override
    public BigDecimal operate(Stack<BigDecimal> numbers) {
        return numbers.pop().subtract(numbers.pop());
    }

    @Override
    public int getNumberNum() {
        return 2;
    }
}
