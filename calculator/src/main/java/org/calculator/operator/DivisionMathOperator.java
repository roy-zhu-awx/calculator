package org.calculator.operator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Stack;

public class DivisionMathOperator implements Operator {

    @Override
    public BigDecimal operate(Stack<BigDecimal> numbers) {
        return numbers.pop().divide(numbers.pop(),new MathContext(15));
    }

    @Override
    public int getNumberNum() {
        return 2;
    }
}
