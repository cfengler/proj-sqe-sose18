package de.tuberlin.sqe.ss18.reqexchange.model.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.rmf.reqif10.ReqIF10Package;
import org.eclipse.rmf.reqif10.serialization.ReqIF10ResourceFactoryImpl;

public class DefaultModelTransformationService implements ModelTransformationService {

    private static final Set<String> SUPPORTED_EXTENSIONS = new HashSet<>(
            Arrays.asList("reqif", "uml", "cm")
    );





    public static void main(String[] args) {




        String resourcePath = "src/main/resources";


        /**
         * Register needed EPackages for Parser etc.
         *
         * This example is for ReqIF
         */
        ReqIF10Package.eINSTANCE.eClass();

        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("reqif", new ReqIF10ResourceFactoryImpl());


        /**
         * Files to be transformed and qvto file
         */

        File inReqIF = new File(resourcePath + "/samplefiles/04_ReqIF_ReqExchange/My.reqif");
        File outReqIF = new File(resourcePath + "/unitTest/MyTransformed.reqif");
        File transformationQVT = new File(resourcePath + "/qvt/ReqIF2ReqIF.qvto");


        boolean result = executeTransformation(inReqIF, outReqIF, transformationQVT);

        System.out.println("Transformation successfull: " + result);

    }









    private static boolean executeTransformation(File inFile, File outFile, File transformationQVTOFile) {
        /**
         * Debug to ensure if file path is correct
         */


        System.out.println(inFile.exists() + " : " +inFile.getAbsolutePath());
        System.out.println(outFile.exists() + " : " +outFile.getAbsolutePath());
        System.out.println(transformationQVTOFile.exists() + " : " +transformationQVTOFile.getAbsolutePath());


        /**
         * Next Part is based on
         * http://wiki.eclipse.org/QVTOML/Examples/InvokeInJava
         */


        // Refer to an existing transformation via URI
        URI transformationURI = URI.createFileURI(transformationQVTOFile.getAbsolutePath());


        // create executor for the given transformation
        TransformationExecutor executor = new TransformationExecutor(transformationURI);

        // define the transformation input
        // Remark: we take the objects from a resource, however
        // a list of arbitrary in-memory EObjects may be passed
        ExecutionContextImpl context = new ExecutionContextImpl();
        ResourceSet resourceSet = new ResourceSetImpl();
        URI uri = URI.createFileURI(inFile.getAbsolutePath());

        Resource inResource = resourceSet.getResource(uri, true);
        EList<EObject> inObjects = inResource.getContents();

        // create the input extent with its initial contents
        ModelExtent input = new BasicModelExtent(inObjects);
        // create an empty extent to catch the output
        ModelExtent output = new BasicModelExtent();

        // setup the execution environment details ->
        // configuration properties, logger, monitor object etc.
        //ExecutionContextImpl context = new ExecutionContextImpl();
        //context.setConfigProperty("keepModeling", true);

        // run the transformation assigned to the executor with the given
        // input and output and execution context -> ChangeTheWorld(in, out)
        // Remark: variable arguments count is supported
        ExecutionDiagnostic result = executor.execute(context, input, output);

        // check the result for success
        if(result.getSeverity() == Diagnostic.OK) {
            // the output objects got captured in the output extent
            List<EObject> outObjects = output.getContents();
            // let's persist them using a resource
            ResourceSet resourceSet2 = new ResourceSetImpl();
            Resource outResource = resourceSet2.createResource(
                    URI.createFileURI(outFile.getAbsolutePath()));
            outResource.getContents().addAll(outObjects);
            try {
                outResource.save(Collections.emptyMap());
                return true;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else {
            // turn the result diagnostic into status and send it to error log
            System.out.println("Transformation failed:" + result);
            return false;
        }
        return false;
    }





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
        else if (sourcePathExtension.equals("reqif") && destinationPathExtension.equals("reqif")) {
            return copy(sourcePath.toFile(), destinationPath.toFile());
        }
        else if (sourcePathExtension.equals("reqif") && destinationPathExtension.equals("uml")) {
            return transformReqifToSysML(sourcePath.toFile(), destinationPath.toFile());
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

    private boolean transformReqifToSysML(File sourceFile, File destinationFile) {
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
