package de.tuberlin.sqe.ss18.reqexchange.model.service;

import java.io.File;

public class ModelValidationService {

    public boolean validateCommonModelFile(File file) {
        if (!file.exists()) {
            return false;
        }

        //TODO: implement validation based on EMF-Validator?

        return false;
    }

    public boolean validateReqIFFile(File file) {
        if (!file.exists()) {
            return false;
        }

        //TODO: implement validation based on EMF-Validator?

        return false;
    }

    public boolean validateSysMLFile(File file) {
        if (!file.exists()) {
            return false;
        }

        //TODO: implement validation based on EMF-Validator?

        return false;
    }

}
