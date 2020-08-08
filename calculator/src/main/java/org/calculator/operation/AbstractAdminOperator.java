package org.calculator.operation;

import org.calculator.step.StepKeeper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

abstract class AbstractAdminOperator implements Operation {
    protected StepKeeper stepKeeper;
    protected String expression;
    public AbstractAdminOperator(StepKeeper stepKeeper, String expression){
        this.stepKeeper = stepKeeper;
        this.expression=expression;
    }

    @Override
    public void restoreOperation(Stack<BigDecimal> stack, List<BigDecimal> numbers) {

    }
}
