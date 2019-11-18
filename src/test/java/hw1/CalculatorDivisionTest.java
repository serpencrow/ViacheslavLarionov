package hw1;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalculatorDivisionTest extends AbstractBaseTest {

    @Test(dataProviderClass = CalculatorDataProvider.class, dataProvider = "divDataProvider")
    public void divisionTest(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }
}
