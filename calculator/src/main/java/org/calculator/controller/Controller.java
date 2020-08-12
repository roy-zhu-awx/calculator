package org.calculator.controller;

import java.math.BigDecimal;
import java.util.Stack;

public interface Controller {
    void doControl(Stack<Stack<BigDecimal>> historySteps,Stack<BigDecimal> stack);
}
