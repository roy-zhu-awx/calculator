package org.calculator.operator;

import org.calculator.constant.SystemConstant;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Stack;

public class SqrtMathOperator implements Operator {

    @Override
    public BigDecimal operate(Stack<BigDecimal> numbers) {
        return sqrt(numbers.pop(), SystemConstant.storedScale);
    }

    @Override
    public int getNumberNum() {
        return 1;
    }

    private BigDecimal sqrt(BigDecimal value, int scale) {
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
