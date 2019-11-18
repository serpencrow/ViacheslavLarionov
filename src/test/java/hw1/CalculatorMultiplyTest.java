package hw1;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalculatorMultiplyTest extends AbstractBaseTest {

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "multDataProvider")
    public void multiplyTest(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }
}
