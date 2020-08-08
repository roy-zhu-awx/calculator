package org.calculator.operation;

import org.calculator.step.StepKeeper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

public class AdditionMathOperator extends AbstractMathOperator {

    public AdditionMathOperator(StepKeeper stepKeeper, String expression) {
        super(stepKeeper, expression);
    }

    @Override
    void _operate(List<BigDecimal> numbers, Stack<BigDecimal> stack) {
        stack.add(numbers.get(0).add(numbers.get(1)));
    }

    @Override
    public Boolean checkValidate(Stack<BigDecimal> stack) {
        if (stack.size()>=2){
            return true;
        }
        return false;
    }
}
