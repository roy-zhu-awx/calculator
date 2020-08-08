import org.calculator.main.Calculator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MixOperatorTestExmple5 {
    private static Calculator calculator;
    String expect;
    String expression;
    @Parameterized.Parameters
    public static Collection<Object[]> initParameters(){
        return Arrays.asList(new Object[][]{
                {"stack:7 6","7 12 2 /"},
                {"stack:42","*"},
                {"stack:10.5","4 /"}
        });
    }

    public MixOperatorTestExmple5(String expect, String expression) {
        this.expect = expect;
        this.expression = expression;
    }
    @BeforeClass
    public static void createCalculator(){
        calculator=new Calculator();
    }

    @Test
    public void testSingleOperator(){
        Assert.assertEquals(expect,calculator.calculator(expression));
    }




}
