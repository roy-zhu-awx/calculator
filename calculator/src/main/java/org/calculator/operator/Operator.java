package org.calculator.operator;

import java.math.BigDecimal;
import java.util.Stack;

public interface Operator {
    BigDecimal operate(Stack<BigDecimal> numbers);

    int getNumberNum();
}
