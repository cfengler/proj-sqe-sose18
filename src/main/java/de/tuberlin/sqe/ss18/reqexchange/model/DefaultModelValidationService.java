package de.tuberlin.sqe.ss18.reqexchange.model;

import java.nio.file.Files;
import java.nio.file.Path;

public class DefaultModelValidationService implements ModelValidationService {

    public boolean validate(Path path) {
        if (path == null || !Files.isRegularFile(path)) {
            return false;
        }

//        if (!file.exists()) {
//            return false;
//        }

        //TODO: implement validation based on EMF-Validator?

        return true;
    }

//    public boolean validateReqIFFile(File file) {
//        if (!file.exists()) {
//            return false;
//        }
//
//        //TODO: implement validation based on EMF-Validator?
//
//        return false;
//    }
//
//    public boolean validateSysMLFile(File file) {
//        if (!file.exists()) {
//            return false;
//        }
//
//        //TODO: implement validation based on EMF-Validator?
//
//        return false;
//    }

}
