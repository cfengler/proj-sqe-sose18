package de.tuberlin.sqe.ss18.reqexchange.model.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DefaultModelTransformationService implements ModelTransformationService {

    @Override
    public boolean transform(Path sourcePath, Path destinationPath) {
        if (sourcePath == null || destinationPath == null) {
            System.out.println("DefaultModelTransformationService.transform parameters null");
            return false;
        }

        if (!Files.isRegularFile(sourcePath) || !Files.isRegularFile(destinationPath)) {
            System.out.println("DefaultModelTransformationService.transform parameters not regular files");
            return false;
        }

        String sourcePathExtension = FilenameUtils.getExtension(sourcePath.toString());
        String destinationPathExtension = FilenameUtils.getExtension(destinationPath.toString());

        if (sourcePathExtension.equals("reqif") && destinationPathExtension.equals("cm")) {
            return transformReqifToCm(sourcePath.toFile(), destinationPath.toFile());
        }
        else if (sourcePathExtension.equals("cm") && destinationPathExtension.equals("reqif")) {
            return transformCmToReqif(sourcePath.toFile(), destinationPath.toFile());
        }
        else if (sourcePathExtension.equals("uml") && destinationPathExtension.equals("cm")) {
            return transformSysMLToCm(sourcePath.toFile(), destinationPath.toFile());
        }
        else if (sourcePathExtension.equals("cm") && destinationPathExtension.equals("uml")) {
            return transformCmToSysML(sourcePath.toFile(), destinationPath.toFile());
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
