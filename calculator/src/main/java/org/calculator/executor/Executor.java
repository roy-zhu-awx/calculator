package org.calculator.executor;

import java.math.BigDecimal;
import java.util.Stack;

public interface Executor {
    void execute(Stack<Stack<BigDecimal>> historySteps, Stack<BigDecimal> stack);
}
