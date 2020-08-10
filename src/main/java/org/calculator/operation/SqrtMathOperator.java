package org.calculator.operation;

import org.calculator.constant.SystemConstant;
import org.calculator.newstep.StepKeeper;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Stack;

public class SqrtMathOperator extends AbstractMathOperator {
    public SqrtMathOperator(StepKeeper stepKeeper, String expression) {
        super(stepKeeper, expression);
    }

    @Override
    protected int getNumberNum() {
        return 1;
    }

    @Override
    protected void _operate(Stack<BigDecimal> numbers, Stack<BigDecimal> stack) {
        stack.add(sqrt(numbers.pop(), SystemConstant.storedScale));
    }

    @Override
    public Boolean checkValidate(Stack<BigDecimal> stack){
        return stack.size() >= getNumberNum();
    }
    public static BigDecimal sqrt(BigDecimal value, int scale){
        BigDecimal num2 = BigDecimal.valueOf(2);
        int precision = 100;
        MathContext mc = new MathContext(precision, RoundingMode.HALF_UP);
        BigDecimal deviation = value;
        int cnt = 0;
        while (cnt < precision) {
            deviation = (deviation.add(value.divide(deviation, mc))).divide(num2, mc);
            cnt++;
        }
        deviation = deviation.setScale(scale, BigDecimal.ROUND_HALF_UP);
        return deviation;
    }
}
