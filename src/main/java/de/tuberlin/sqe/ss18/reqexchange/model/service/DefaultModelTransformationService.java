package de.tuberlin.sqe.ss18.reqexchange.model.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DefaultModelTransformationService implements ModelTransformationService {

    private static final Set<String> SUPPORTED_EXTENSIONS = new HashSet<>(
            Arrays.asList("reqif", "uml", "cm")
    );

    @Override
    public boolean transform(Path sourcePath, Path destinationPath) {
        if (sourcePath == null || destinationPath == null) {
            System.out.println("DefaultModelTransformationService.transform parameters null");
            return false;
        }

        String sourcePathExtension = FilenameUtils.getExtension(sourcePath.toString());
        String destinationPathExtension = FilenameUtils.getExtension(destinationPath.toString());

        if (!SUPPORTED_EXTENSIONS.contains(sourcePathExtension) || !SUPPORTED_EXTENSIONS.contains(destinationPathExtension)) {
            System.out.println("DefaultModelTransformationService.transform files has unsupported extensions");
            return false;
        }

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
        //TODO: also first validate source Files with Model Validator
        //TODO: remove with correct implementation
        return copy(sourceFile, destinationFile);
    }

    private boolean transformCmToReqif(File sourceFile, File destinationFile) {
        //TODO: also first validate source Files with Model Validator
        //TODO: remove with correct implementation
        return copy(sourceFile, destinationFile);
    }

    private boolean transformSysMLToCm(File sourceFile, File destinationFile) {
        //TODO: also first validate source Files with Model Validator
        //TODO: remove with correct implementation
        return copy(sourceFile, destinationFile);
    }

    private boolean transformCmToSysML(File sourceFile, File destinationFile) {
        //TODO: also first validate source Files with Model Validator
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
