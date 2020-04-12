package com.myfin.other;

import com.google.gson.Gson;
import com.myfin.model.Properties;
import utils.FileUtils;

public class JsonReader {
    private Properties properties;

    public JsonReader() {
        properties = readPropertiesFromFile();
    }

    private Properties readPropertiesFromFile() {
        Gson gson = new Gson();
        String propertyFilePath = System.getProperty("user.dir") + "/src/test/resources/properties.json";
        return gson.fromJson(new FileUtils().getFileContent(propertyFilePath), Properties.class);
    }

    public Properties getProperties() {
        return properties;
    }
}
