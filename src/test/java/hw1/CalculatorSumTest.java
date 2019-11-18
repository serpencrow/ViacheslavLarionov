package hw1;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalculatorSumTest extends AbstractBaseTest {

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "sumDataProvider")
    public void sumTest(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }
}
