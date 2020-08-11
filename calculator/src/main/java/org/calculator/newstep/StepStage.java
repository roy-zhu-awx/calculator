package org.calculator.newstep;

import java.math.BigDecimal;
import java.util.Stack;

public class StepStage {
    private Stack<BigDecimal> stack;
    public StepStage(Stack<BigDecimal> stack){
        this.stack=stack;
    }

    public Stack<BigDecimal> getStage() {
        return stack;
    }

    public void restoreStep(Step step){
        Stack<BigDecimal> numbers= step.getNumbers();
        stack.pop();
        while (!numbers.empty()){
            stack.push(numbers.pop());
        }
    }
}
