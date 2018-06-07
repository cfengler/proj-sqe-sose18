package de.tuberlin.sqe.ss18.reqexchange.common.service;

import com.google.gson.*;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


@Component
public class JsonSerializerService {

    private Gson gson;

    public JsonSerializerService() {

        //gson = JsonFactory.create();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.serializeNulls();

        this.gson = gsonBuilder
            .registerTypeAdapter(DateTime.class, (JsonSerializer<DateTime>) (json, typeOfSrc, context) -> {
                return new JsonPrimitive(ISODateTimeFormat.dateTime().print(json));
            })
            .registerTypeAdapter(DateTime.class, (JsonDeserializer<DateTime>) (json, typeOfT, context) -> {
                DateTime dt = ISODateTimeFormat.dateTime().parseDateTime(json.getAsString());
                return dt;
            })
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

    public <T> T deserialize(File file, Class<T> classOfT) {
        try (FileReader fileReader = new FileReader(file.getAbsolutePath())) {
            return gson.fromJson(fileReader, classOfT);
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
