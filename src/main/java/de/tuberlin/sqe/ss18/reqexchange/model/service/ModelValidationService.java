package de.tuberlin.sqe.ss18.reqexchange.model.service;

import java.io.File;

public interface ModelValidationService {

    boolean validateCommonModelFile(File file);
    boolean validateReqIFFile(File file);
    boolean validateSysMLFile(File file);

}
