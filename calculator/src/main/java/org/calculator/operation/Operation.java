package org.calculator.operation;

import org.calculator.step.StepStage;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

public interface Operation {
    void operate(StepStage stepStage);
    void restoreOperation(Stack<BigDecimal> stack, List<BigDecimal> numbers);
    Boolean checkValidate(Stack<BigDecimal> stack);
}
