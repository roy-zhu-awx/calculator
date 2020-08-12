package org.calculator.controller;

import java.math.BigDecimal;
import java.util.Stack;

public class UndoController implements Controller {
    @Override
    public void doControl(Stack<Stack<BigDecimal>> historySteps, Stack<BigDecimal> stack) {
        stack.pop();
        Stack<BigDecimal> numbers=historySteps.pop();
        int num=numbers.size();
        for(int i=0;i<num;i++){
            stack.push(numbers.pop());
        }
    }
}
