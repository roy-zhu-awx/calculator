package org.calculator.operator;

import java.math.BigDecimal;
import java.util.Stack;

public class AdditionMathOperator implements Operator {

    @Override
    public BigDecimal operate(Stack<BigDecimal> numbers) {
        return numbers.pop().add(numbers.pop());
    }

    @Override
    public int getNumberNum() {
        return 2;
    }
}
