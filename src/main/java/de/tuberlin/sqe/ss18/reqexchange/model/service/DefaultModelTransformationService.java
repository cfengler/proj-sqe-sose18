package de.tuberlin.sqe.ss18.reqexchange.model.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;

public class DefaultModelTransformationService implements ModelTransformationService {

    @Override
    public boolean transform(File sourceFile, File destinationFile) {
        if (sourceFile == null || destinationFile == null) {
            return false;
        }

        String sourceFileExtension = FilenameUtils.getExtension(sourceFile.getName());
        String destinationFileExtension = FilenameUtils.getExtension(destinationFile.getName());

        if (FilenameUtils.getExtension(sourceFile.getName()).equals("reqif")
                && FilenameUtils.getExtension(destinationFile.getName()).equals("cm")) {
            return transformReqifToCm(sourceFile, destinationFile);
        }
        else if (sourceFileExtension.equals("cm")
                && destinationFileExtension.equals("reqif")) {
            return transformCmToReqif(sourceFile, destinationFile);
        }
        else if (sourceFileExtension.equals("uml")
                && destinationFileExtension.equals("cm")) {
            return transformSysMLToCm(sourceFile, destinationFile);
        }
        else if (sourceFileExtension.equals("cm")
                && destinationFileExtension.equals("uml")) {
            return transformCmToSysML(sourceFile, destinationFile);
        }
        else {
            System.out.println("DefaultModelTransformationService.transform Extension not supported");
            return false;
        }
    }

    private boolean transformReqifToCm(File sourceFile, File destinationFile) {
        //TODO: remove with correct implementation
        return copy(sourceFile, destinationFile);
    }

    private boolean transformCmToReqif(File sourceFile, File destinationFile) {
        //TODO: remove with correct implementation
        return copy(sourceFile, destinationFile);
    }

    private boolean transformSysMLToCm(File sourceFile, File destinationFile) {
        //TODO: remove with correct implementation
        return copy(sourceFile, destinationFile);
    }

    private boolean transformCmToSysML(File sourceFile, File destinationFile) {
        //TODO: remove with correct implementation
        return copy(sourceFile, destinationFile);
    }

    //TODO: remove when other model transformations work
    private boolean copy(File sourceFile, File destinationFile) {
        if (!sourceFile.exists()) {
            return false;
        }

        try {
            FileUtils.copyFile(sourceFile, destinationFile);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
