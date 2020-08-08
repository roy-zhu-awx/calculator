package org.calculator.operation;

import org.calculator.step.StepKeeper;
import org.calculator.step.StepStage;

import java.math.BigDecimal;
import java.util.Stack;

public class ClearMathOperator extends AbstractAdminOperator {
    public ClearMathOperator(StepKeeper stepKeeper, String expression) {
        super(stepKeeper, expression);
    }

    @Override
    public void operate(StepStage stepStage) {
        stepStage.getStage().clear();
        stepKeeper.clearAllSteps();
    }

    @Override
    public Boolean checkValidate(Stack<BigDecimal> stack){
        return true;
    }
}
