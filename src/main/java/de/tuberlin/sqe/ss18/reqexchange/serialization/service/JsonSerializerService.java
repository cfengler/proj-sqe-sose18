package de.tuberlin.sqe.ss18.reqexchange.serialization.service;

import java.io.File;

public interface JsonSerializerService {
    void serializeToFile(Object object, File file);
    <T> T deserializeToObject(File file, Class<T> classOf);
}
