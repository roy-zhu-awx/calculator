package org.calculator.operation;


import org.calculator.newstep.StepKeeper;

abstract class AbstractAdminOperator implements Operation {
    protected StepKeeper stepKeeper;
    protected String expression;
    public AbstractAdminOperator(StepKeeper stepKeeper, String expression){
        this.stepKeeper = stepKeeper;
        this.expression=expression;
    }
}
