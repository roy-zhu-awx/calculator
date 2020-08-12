package org.calculator.operation;

import java.math.BigDecimal;
import java.util.Stack;

public class NumberOperation implements Operation {

    @Override
    public BigDecimal operate(Stack<BigDecimal> numbers) {
        return numbers.pop();
    }

    @Override
    public int getNumberNum() {
        return 0;
    }

}
