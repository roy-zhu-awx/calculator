import org.calculator.core.Calculator;
import org.calculator.main.RunStart;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MixOperatorTestExmple8 {
    private static RunStart runStart;
    String expect;
    String expression;
    @Parameterized.Parameters
    public static Collection<Object[]> initParameters(){
        return Arrays.asList(new Object[][]{
                {"operator * (position: 15): insufficient parameters\n" +
                        "stack:11","1 2 3 * 5 + * * 6 5"}
        });
    }

    public MixOperatorTestExmple8(String expect, String expression) {
        this.expect = expect;
        this.expression = expression;
    }
    @BeforeClass
    public static void createCalculator(){
        runStart=new RunStart();
    }

    @Test
    public void testSingleOperator(){
        Assert.assertEquals(expect,runStart.getResult(expression));
    }




}
