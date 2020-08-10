package org.calculator.operation;


import org.calculator.newstep.StepKeeper;

import java.math.BigDecimal;
import java.util.Stack;

public class NumberOperation extends AbstractMathOperator {

    public NumberOperation(StepKeeper stepKeeper, String expression) {
        super(stepKeeper, expression);
    }

    @Override
    protected int getNumberNum() {
        return 0;
    }

    @Override
    protected void _operate(Stack<BigDecimal> numbers, Stack<BigDecimal> stack) {
        stack.add(new BigDecimal(expression));
    }

    @Override
    protected Stack<BigDecimal> getOperatorNumber(Stack<BigDecimal> stack) {
        return new Stack<>();
    }

    @Override
    public Boolean checkValidate(Stack<BigDecimal> stack){
        return true;
    }
}
