package org.calculator.operation;

import org.calculator.step.StepKeeper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MultiplicationMathOperator extends AbstractMathOperator {
    public MultiplicationMathOperator(StepKeeper stepKeeper, String expression) {
        super(stepKeeper, expression);
    }

    @Override
    public List<BigDecimal> getOperatorNumber(Stack<BigDecimal> stack) {
        List<BigDecimal> numbers=new ArrayList<>(2);
        BigDecimal first=stack.pop();
        BigDecimal second=stack.pop();
        numbers.add(second);
        numbers.add(first);
        return numbers;
    }

    @Override
    void _operate(List<BigDecimal> numbers, Stack<BigDecimal> stack) {
        stack.add(numbers.get(0).multiply(numbers.get(1)));
    }

    @Override
    public Boolean checkValidate(Stack<BigDecimal> stack){
        return stack.size() >= 2;
    }
}
