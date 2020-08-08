package org.calculator.operation;

import org.calculator.step.StepKeeper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NumberOperation extends AbstractMathOperator {

    public NumberOperation(StepKeeper stepKeeper, String expression) {
        super(stepKeeper, expression);
    }

    @Override
    public List<BigDecimal> getOperatorNumber(Stack<BigDecimal> stack) {
        List<BigDecimal> numbers=new ArrayList<>();
        try {
            numbers.add(new BigDecimal(expression));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numbers;
    }

    @Override
    void _operate(List<BigDecimal> numbers, Stack<BigDecimal> stack) {
        stack.add(new BigDecimal(expression));
    }

    @Override
    public void restoreOperation(Stack<BigDecimal> stack, List<BigDecimal> numbers) {
        stack.pop();
    }

    @Override
    public Boolean checkValidate(Stack<BigDecimal> stack){
        return true;
    }
}
