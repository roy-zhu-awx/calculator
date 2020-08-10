package org.calculator.operation;
import org.calculator.newstep.StepStage;

import java.math.BigDecimal;
import java.util.Stack;

public interface Operation {
    void operate(StepStage stepStage);
    Boolean checkValidate(Stack<BigDecimal> stack);
}
