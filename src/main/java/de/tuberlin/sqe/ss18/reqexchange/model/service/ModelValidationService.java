package de.tuberlin.sqe.ss18.reqexchange.model.service;

import java.nio.file.Path;

public interface ModelValidationService {

    boolean validate(Path path);
    //boolean validateReqIFFile(File file);
    //boolean validateSysMLFile(File file);

}
