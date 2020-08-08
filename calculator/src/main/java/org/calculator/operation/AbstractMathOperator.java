package org.calculator.operation;

import org.calculator.step.StepKeeper;
import org.calculator.step.Step;
import org.calculator.step.StepStage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class AbstractMathOperator implements Operation {
    protected StepKeeper stepKeeper;
    protected String expression;
    public AbstractMathOperator(StepKeeper stepKeeper, String expression){
        this.stepKeeper = stepKeeper;
        this.expression=expression;
    }

    @Override
    public void operate(StepStage stepStage) {
        Stack<BigDecimal> stack= stepStage.getStage();
        List<BigDecimal> numbers=getOperatorNumber(stack);
        stepKeeper.addStep(new Step(numbers,this));
        _operate(numbers, stepStage.getStage());
    }

    @Override
    public void restoreOperation(Stack<BigDecimal> stack, List<BigDecimal> numbers) {
        stack.pop();
        stack.addAll(numbers);
    }

    protected List<BigDecimal> getOperatorNumber(Stack<BigDecimal> stack){
        List<BigDecimal> numbers=new ArrayList<>(2);
        BigDecimal first=stack.pop();
        BigDecimal second=stack.pop();
        numbers.add(second);
        numbers.add(first);
        return numbers;
    }
    abstract void _operate(List<BigDecimal> numbers,Stack<BigDecimal> stack);
}
