package data;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

abstract class JsonResourceReader<T> {

    protected abstract String getResourceFilePath();

    T readConfig(Class<T> contentClass){
        List<T> configs = new ArrayList<>();
        Gson gson = new Gson();

        String jsonInString;
        try {
            jsonInString = ResourceUtility.readLinesFromResourcesAsString(getResourceFilePath());
            return gson.fromJson(jsonInString, contentClass);

        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Could not read config for " + getResourceFilePath());
    }
}