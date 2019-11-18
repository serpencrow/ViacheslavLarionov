package hw1;

import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {

    @DataProvider
    public Object[][] sumDataProvider() {
        return new Object[][] {
                {1,  2,  3},
                {3,  4,  7},
                {26, 4, 30},
        };
    }

    @DataProvider
    public Object[][] subDataProvider() {
        return new Object[][] {
                {12,  5,   7},
                {33, 34,  -1},
                {4, 401,-397},
        };
    }

    @DataProvider
    public Object[][] multDataProvider() {
        return new Object[][] {
                { 1, 2, 2},
                { 3, 4, 12},
                {26, 4, 104},
        };
    }

    @DataProvider
    public Object[][] divDataProvider() {
        return new Object[][] {
                {12, 6,  2},
                {6,  2,  3},
                {26, 2, 13},
        };
    }
}
