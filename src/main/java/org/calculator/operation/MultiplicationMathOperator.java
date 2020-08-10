package org.calculator.operation;


import org.calculator.newstep.StepKeeper;

import java.math.BigDecimal;
import java.util.Stack;

public class MultiplicationMathOperator extends AbstractMathOperator {
    public MultiplicationMathOperator(StepKeeper stepKeeper, String expression) {
        super(stepKeeper, expression);
    }

    @Override
    protected int getNumberNum() {
        return 2;
    }

    @Override
    protected void _operate(Stack<BigDecimal> numbers, Stack<BigDecimal> stack) {
        stack.add(numbers.pop().multiply(numbers.pop()));
    }

    @Override
    public Boolean checkValidate(Stack<BigDecimal> stack){
        return stack.size() >= getNumberNum();
    }
}
