package hw4;

import hw4.ex2.TestData;
import hw4.ex2.enums.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.String.format;
import static org.apache.commons.collections4.CollectionUtils.isEmpty;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

public class Utils {

    public static UserInfo getUserInfoFromPropertyFile(final String propertyFilePath) {

        UserInfo userInfo = null;

        try {
            File propertiesFile = new File(propertyFilePath);
            Properties properties = new Properties();
            properties.load(new FileReader(propertiesFile));

            userInfo = new UserInfo(
                    properties.getProperty("username"),
                    properties.getProperty("password"),
                    properties.getProperty("usernameLabel")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userInfo;
    }

    public static List<String> formExpectedLogListFromTestData(final TestData testData) {
        List<String> expectedLogList = new ArrayList<>();

        if (isNotEmpty(testData.getNumbers())) {
            AtomicInteger summary = new AtomicInteger();
            testData.getNumbers().forEach(number ->
                    summary.addAndGet(Integer.parseInt((number.getNumberValue())))
            );
            expectedLogList.add(format("Summary: %d", summary.get()));
        }

        if (testData.getColor() != null) {
            expectedLogList.add(format("Color: %s", testData.getColor().getColorName()));
        }

        if (testData.getMetal() != null) {
            expectedLogList.add(format("Metal: %s", testData.getMetal().getMetalName()));
        }

        if (isNotEmpty(testData.getVegetables())) {
            StringBuilder builder = new StringBuilder("Vegetables: ");
            AtomicInteger vegetablesCount = new AtomicInteger(testData.getVegetables().size());

            for (Vegetables vegetable : testData.getVegetables()) {
                builder.append(vegetable.getVegetableName());

                if (vegetablesCount.get() != 1) {
                    builder.append(", ");
                }

                vegetablesCount.decrementAndGet();
            }

            expectedLogList.add(builder.toString());
        }

        if (isNotEmpty(testData.getElements())) {
            StringBuilder builder = new StringBuilder("Elements: ");
            AtomicInteger elementsCount = new AtomicInteger(testData.getElements().size());

            for (Elements element : testData.getElements()) {
                builder.append(element.getElementName());

                if (elementsCount.get() != 1) {
                    builder.append(", ");
                }

                elementsCount.decrementAndGet();
            }

            expectedLogList.add(builder.toString());
        }

        return expectedLogList;
    }

    public static List<String> formActualLogListFromCurrentAndTestData(final List<String> currentLogList,
                                                                       final TestData testData) {
        List<String> actualResults = new ArrayList<>();

        for (String logRow : currentLogList) {
            if (logRow.contains("Summary") & isEmpty(testData.getNumbers())) {
                continue;
            }

            if (logRow.contains("Color") & (testData.getColor() == null)) {
                continue;
            }

            if (logRow.contains("Metal") & (testData.getMetal() == null)) {
                continue;
            }

            if (logRow.contains("Vegetables") & isEmpty(testData.getVegetables())) {
                continue;
            }

            if (logRow.contains("Elements") & isEmpty(testData.getElements())) {
                continue;
            }
            actualResults.add(logRow);
        }

        return actualResults;
    }
}
