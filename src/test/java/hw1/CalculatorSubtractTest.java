package hw1;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalculatorSubtractTest extends AbstractBaseTest {

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "subDataProvider")
    public void subtractTest(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }
}
