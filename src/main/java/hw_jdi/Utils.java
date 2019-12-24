package hw_jdi;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.String.format;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

public class Utils {

    public static JdiUser getUserInfoFromPropertyFile(final String propertyFilePath) {

        JdiUser jdiUser = null;

        try {
            File propertiesFile = new File(propertyFilePath);
            Properties properties = new Properties();
            properties.load(new FileReader(propertiesFile));

            jdiUser = new JdiUser(
                    properties.getProperty("username"),
                    properties.getProperty("password"),
                    properties.getProperty("fullname")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jdiUser;
    }

    public static List<String> formExpectedLogListFromTestData(final MetalsAndColorsFormData formData) {
        List<String> expectedLogList = new ArrayList<>();

        if (isNotEmpty(formData.getSummary())) {
            AtomicInteger summary = new AtomicInteger();
            formData.getSummary().forEach(summary::addAndGet);
            expectedLogList.add(format("Summary: %d", summary.get()));
        }

        if (isNotEmpty(formData.getElements())) {
            String elementsList = String.join(", ", formData.getElements());
            expectedLogList.add(String.join(" ", "Elements:", elementsList));
        }

        if (formData.getColor() != null) {
            expectedLogList.add(format("Color: %s", formData.getColor()));
        }

        if (formData.getMetals() != null) {
            expectedLogList.add(format("Metal: %s", formData.getMetals()));
        }

        if (isNotEmpty(formData.getVegetables())) {
            String vegetablesList = String.join(", ", formData.getVegetables());
            expectedLogList.add(String.join(" ", "Vegetables:", vegetablesList));
        }

        return expectedLogList;
    }
}
