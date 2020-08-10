package org.calculator.operation;


import org.calculator.newstep.StepKeeper;

import java.math.BigDecimal;
import java.util.Stack;

public class AdditionMathOperator extends AbstractMathOperator {

    public AdditionMathOperator(StepKeeper stepKeeper, String expression) {
        super(stepKeeper, expression);
    }

    @Override
    protected int getNumberNum() {
        return 2;
    }

    @Override
    protected void _operate(Stack<BigDecimal> numbers, Stack<BigDecimal> stack) {
        stack.add(numbers.pop().add(numbers.pop()));
    }

    @Override
    public Boolean checkValidate(Stack<BigDecimal> stack) {
        return stack.size() >= getNumberNum();
    }
}
