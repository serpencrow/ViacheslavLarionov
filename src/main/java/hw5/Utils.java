package hw5;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

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
}
