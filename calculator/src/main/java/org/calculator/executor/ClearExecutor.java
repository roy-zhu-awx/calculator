package org.calculator.executor;

import java.math.BigDecimal;
import java.util.Stack;

public class ClearExecutor implements Executor {
    @Override
    public void execute(Stack<Stack<BigDecimal>> historySteps, Stack<BigDecimal> stack) {
        historySteps.clear();
        stack.clear();
    }
}
