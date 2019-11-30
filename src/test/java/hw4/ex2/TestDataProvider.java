package hw4.ex2;

import hw4.ex2.enums.*;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

import static hw4.ex2.TestData.testDataBuilder;

public class TestDataProvider {

    @DataProvider()
    public Object[][] getFormTestData() {
        return new Object[][] {
                {testDataBuilder()
                        .setElements(Arrays.asList(Elements.EARTH))
                        .setColor(Colors.YELLOW)
                        .setMetal(Metals.GOLD)
                        .build()},

                {testDataBuilder()
                        .setNumbers(Arrays.asList(Numbers.THREE, Numbers.EIGHT))
                        .setVegetables(Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO))
                        .build()},

                {testDataBuilder()
                        .setNumbers(Arrays.asList(Numbers.THREE, Numbers.TWO))
                        .setElements(Arrays.asList(Elements.WATER ,Elements.WIND, Elements.FIRE))
                        .setMetal(Metals.BRONZE)
                        .setVegetables(Arrays.asList(Vegetables.ONION))
                        .build()},

                {testDataBuilder()
                        .setNumbers(Arrays.asList(Numbers.SIX, Numbers.FIVE))
                        .setElements(Arrays.asList(Elements.WATER))
                        .setColor(Colors.GREEN)
                        .setMetal(Metals.SELEN)
                        .setVegetables(Arrays.asList(Vegetables.CUCUMBER,
                                Vegetables.TOMATO,
                                Vegetables.VEGETABLES,
                                Vegetables.ONION))
                        .build()},

                {testDataBuilder()
                        .setElements(Arrays.asList(Elements.FIRE))
                        .setColor(Colors.BLUE)
                        .setVegetables(Arrays.asList(Vegetables.CUCUMBER,
                                Vegetables.TOMATO,
                                Vegetables.VEGETABLES))
                        .build()}
        };
    }
}
