package de.tuberlin.sqe.ss18.reqexchange.serialization;

import com.google.gson.*;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DefaultJsonSerializerService implements JsonSerializerService {

    private Gson gson;

    public DefaultJsonSerializerService() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.serializeNulls();

        this.gson = gsonBuilder
            .registerTypeAdapter(DateTime.class, (JsonSerializer<DateTime>) (json, typeOfSrc, context) -> new JsonPrimitive(ISODateTimeFormat.dateTime().print(json)))
            .registerTypeAdapter(DateTime.class, (JsonDeserializer<DateTime>) (json, typeOfT, context) -> ISODateTimeFormat.dateTime().parseDateTime(json.getAsString()))
            .create();
    }



    public void serializeToFile(Object object, File file) {
        try {
            try (FileWriter fileWriter = new FileWriter(file.getAbsolutePath())) {
                gson.toJson(object, fileWriter);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T> T deserializeToObject(File file, Class<T> classOfT) {
        try (FileReader fileReader = new FileReader(file.getAbsolutePath())) {
            return gson.fromJson(fileReader, classOfT);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
