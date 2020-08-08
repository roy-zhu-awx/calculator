package org.calculator.step;

import java.math.BigDecimal;
import java.util.List;
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
        List<BigDecimal> numbers= step.getNumbers();
        step.getOperation().restoreOperation(stack,numbers);
    }
}
