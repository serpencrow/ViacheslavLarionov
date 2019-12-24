package hw_jdi;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;

public class MetalsAndColorsFormDataProvider {

    @DataProvider(name = "metalsAndColorsFormData")
    public Object[] getData() {
        try (Reader reader = new FileReader(Constants.JSON_PROPERTIES_FILE)) {
            Map<String, MetalsAndColorsFormData> data = new Gson()
                    .fromJson(reader, new TypeToken<Map<String, MetalsAndColorsFormData>>(){}.getType()
            );

            return data.values().toArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
