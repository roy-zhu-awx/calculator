package org.calculator.operation;

import org.calculator.step.StepKeeper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SubtractionMathOperator extends AbstractMathOperator {
    public SubtractionMathOperator(StepKeeper stepKeeper, String expression) {
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
        stack.add(numbers.get(0).subtract(numbers.get(1)));
    }

    @Override
    public Boolean checkValidate(Stack<BigDecimal> stack){
        if (stack.size()>=2){
            return true;
        }
        return false;
    }
}
