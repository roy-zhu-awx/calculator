package org.calculator.operation;

import java.math.BigDecimal;
import java.util.Stack;

public interface Operation {
    BigDecimal operate(Stack<BigDecimal> numbers);
    int getNumberNum();
}
