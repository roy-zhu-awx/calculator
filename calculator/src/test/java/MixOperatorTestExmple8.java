import org.calculator.main.Calculator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Suite;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MixOperatorTestExmple8 {
    private static Calculator calculator;
    String expect;
    String expression;
    @Parameterized.Parameters
    public static Collection<Object[]> initParameters(){
        return Arrays.asList(new Object[][]{
                {"stack:11","1 2 3 * 5 + * * 6 5"}
        });
    }

    public MixOperatorTestExmple8(String expect, String expression) {
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
