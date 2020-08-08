package org.calculator.step;

import org.calculator.operation.Operation;

import java.math.BigDecimal;
import java.util.List;

public class Step {
    private List<BigDecimal> numbers;
    private Operation operation;

    public Step(List<BigDecimal> numbers, Operation operation) {
        this.numbers = numbers;
        this.operation = operation;
    }

    public List<BigDecimal> getNumbers() {
        return numbers;
    }

    public Operation getOperation() {
        return operation;
    }
}
