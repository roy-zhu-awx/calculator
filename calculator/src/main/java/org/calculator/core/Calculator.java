package org.calculator.core;

import org.calculator.newstep.StepKeeper;
import org.calculator.newstep.StepStage;
import org.calculator.operation.Operation;
import org.calculator.operation.OperationFactory;

import java.math.BigDecimal;
import java.util.Stack;

public class Calculator {
    private Stack<BigDecimal> stack;
    private StepKeeper stepKeeper;
    private StepStage stepStage;

    public Calculator(){
        stack=new Stack<>();
        stepKeeper =new StepKeeper();
        stepStage =new StepStage(stack);
    }

    public Boolean calculator(Token token){
        Operation operation= OperationFactory.createOperation(token.getExpression(), stepKeeper);
        if(!operation.checkValidate(stack)){
            return false;
        }else {
            operation.operate(stepStage);
            return true;
        }
    }

    public Stack<BigDecimal> getStack() {
        return stack;
    }
}
