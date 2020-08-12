package org.calculator.controller;

import java.math.BigDecimal;
import java.util.Stack;

public class ClearController implements Controller {
    @Override
    public void doControl(Stack<Stack<BigDecimal>> historySteps, Stack<BigDecimal> stack) {
        historySteps.clear();
        stack.clear();
    }
}
