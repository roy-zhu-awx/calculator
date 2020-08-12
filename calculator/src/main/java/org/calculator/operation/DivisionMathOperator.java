package org.calculator.operation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Stack;

public class DivisionMathOperator implements Operation{

    @Override
    public BigDecimal operate(Stack<BigDecimal> numbers) {
        return numbers.pop().divide(numbers.pop(),new MathContext(15));
    }

    @Override
    public int getNumberNum() {
        return 2;
    }
}
