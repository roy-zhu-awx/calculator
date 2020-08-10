package org.calculator.operation;

import org.calculator.newstep.Step;
import org.calculator.newstep.StepKeeper;
import org.calculator.newstep.StepStage;

import java.math.BigDecimal;
import java.util.Stack;

abstract class AbstractMathOperator implements Operation {
    protected StepKeeper stepKeeper;
    protected String expression;
    public AbstractMathOperator(StepKeeper stepKeeper, String expression){
        this.stepKeeper = stepKeeper;
        this.expression=expression;
    }

    @Override
    public void operate(StepStage stepStage) {
        Stack<BigDecimal> stack= stepStage.getStage();
        Stack<BigDecimal> numbers=new Stack<>();
        Step step=new Step();
        for(int i=0;i<getNumberNum();i++){
            BigDecimal number=stack.pop();
            numbers.push(number);
            step.addNumber(number);
        }
        stepKeeper.addStep(step);
        _operate(numbers, stepStage.getStage());
    }

    protected Stack<BigDecimal> getOperatorNumber(Stack<BigDecimal> stack){
        Stack<BigDecimal> numbers=new Stack<>();
        for(int i=0;i<getNumberNum();i++){
            numbers.push(stack.pop());
        }
        return numbers;
    }

    protected abstract int getNumberNum();
    protected abstract void _operate(Stack<BigDecimal> numbers,Stack<BigDecimal> stack);
}
