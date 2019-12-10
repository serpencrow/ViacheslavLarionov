package hw6;

import com.google.common.collect.Lists;
import hw4.ex2.enums.Elements;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class Utils {

    public static UserInfo getUserInfoFromPropertyFile(final String propertyFilePath,
                                                       final String username) {

        UserInfo userInfo = null;

        try {
            File propertiesFile = new File(propertyFilePath);
            Properties properties = new Properties();
            properties.load(new FileReader(propertiesFile));

            Object[] propertyNames = properties.stringPropertyNames().toArray();
            String userProperty = "";
            for (int i = 0; i < propertyNames.length; ++i) {
                if (username.equals(properties
                        .getProperty((String) propertyNames[i]))) {
                    userProperty = StringUtils.substringBefore((String) propertyNames[i], ".");
                    break;
                } else {
                    i += 2;
                }
            }

            if ("".equals(userProperty))
                throw new IllegalArgumentException(
                        format("User '%s' not found", username));

            userInfo = new UserInfo(
                    properties.getProperty(userProperty + ".username"),
                    properties.getProperty(userProperty + ".password")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userInfo;
    }

    public static boolean isElementsListDisplayed(final List<WebElement> elements) {
        return elements.stream().allMatch(WebElement::isDisplayed);
    }

    public static List<String> getWebElementTexts(final List<WebElement> elements) {
        List<String> elementNames = new ArrayList<>();
        elements.forEach(element -> elementNames.add(element.getText()
                .replaceAll("\n", " ")));
        return elementNames;
    }

    public static boolean isElementsListContainsAll(final List<String> expectedElements,
                                                    final List<String> actualElements) {
        return CollectionUtils.containsAll(actualElements, expectedElements);
    }
}
