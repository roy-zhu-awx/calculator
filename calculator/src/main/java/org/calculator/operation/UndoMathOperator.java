package org.calculator.operation;

import org.calculator.step.StepKeeper;
import org.calculator.step.Step;
import org.calculator.step.StepStage;

import java.math.BigDecimal;
import java.util.Stack;


public class UndoMathOperator extends AbstractAdminOperator {
    public UndoMathOperator(StepKeeper stepKeeper, String expression) {
        super(stepKeeper, expression);
    }

    @Override
    public void operate(StepStage stepStage) {
        Step step = stepKeeper.getStep();
        stepStage.restoreStep(step);
    }

    @Override
    public Boolean checkValidate(Stack<BigDecimal> stack){
        if(stepKeeper.stepStackSize()>0){
            return true;
        }
        System.err.println("there has no step to undo");
        return false;
    }

}
