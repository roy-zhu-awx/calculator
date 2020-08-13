package org.calculator.executor;

import java.math.BigDecimal;
import java.util.Stack;

public class UndoExecutor implements Executor {
    @Override
    public void execute(Stack<Stack<BigDecimal>> historySteps, Stack<BigDecimal> stack) {
        stack.pop();
        Stack<BigDecimal> numbers = historySteps.pop();
        int num = numbers.size();
        for (int i = 0; i < num; i++) {
            stack.push(numbers.pop());
        }
    }
}
