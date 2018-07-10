package de.tuberlin.sqe.ss18.reqexchange;

import de.tuberlin.sqe.ss18.reqexchange.common.service.PathService;
import de.tuberlin.sqe.ss18.reqexchange.common.service.TestPathService;
import de.tuberlin.sqe.ss18.reqexchange.git.service.DefaultGitPropertiesService;
import de.tuberlin.sqe.ss18.reqexchange.git.service.DefaultGitService;
import de.tuberlin.sqe.ss18.reqexchange.git.service.GitPropertiesService;
import de.tuberlin.sqe.ss18.reqexchange.git.service.GitService;
import de.tuberlin.sqe.ss18.reqexchange.model.service.*;
import de.tuberlin.sqe.ss18.reqexchange.project.service.DefaultProjectService;
import de.tuberlin.sqe.ss18.reqexchange.project.service.ProjectService;
import de.tuberlin.sqe.ss18.reqexchange.serialization.service.DefaultJsonSerializerService;
import de.tuberlin.sqe.ss18.reqexchange.serialization.service.JsonSerializerService;
import org.apache.commons.io.FileUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.eclipse.rmf.reqif10.*;
import org.eclipse.rmf.reqif10.impl.*;
import org.eclipse.rmf.reqif10.serialization.ReqIF10ResourceFactoryImpl;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

public class UnitTestHelper {

    public static final String TEST_PROJECT_NAME = "Test Project";
    public static final String RENAMED_PROJECT_NAME = "Renamed Project";
    public static final String VALIDATE_PROJECT_NAME = "Validate Project";

    public static final String NEW_REQUIREMENT_DESCRIPTION_1 = "New Requirement Description 1";
    public static final String NEW_REQUIREMENT_DESCRIPTION_2 = "New Requirement Description 2";

    public static final String CHANGED_REQUIREMENT_DESCRIPTION_1 = "Changed Requirement Description 1";
    public static final String CHANGED_REQUIREMENT_DESCRIPTION_2 = "Changed Requirement Description 2";

    private static PathService pathService;
    public static PathService getPathService() {
        if (pathService == null) {
            pathService = new TestPathService();
        }
        return pathService;
    }

    private static GitPropertiesService gitPropertiesService;
    public static GitPropertiesService getGitPropertiesService() {
        if (gitPropertiesService == null) {
            gitPropertiesService = new DefaultGitPropertiesService(getPathService());
        }
        return gitPropertiesService;
    }

    private static GitService gitService;
    public static GitService getGitService() {
        if (gitService == null) {
            gitService = new DefaultGitService(getPathService(), getGitPropertiesService());
        }
        return gitService;
    }

    private static JsonSerializerService jsonSerializerService;
    public static JsonSerializerService getJsonSerializerService() {
        if (jsonSerializerService == null) {
            jsonSerializerService = new DefaultJsonSerializerService();
        }
        return jsonSerializerService;
    }

    private static ModelTransformationService modelTransformationService;
    public static ModelTransformationService getModelTransformationService() {
        if (modelTransformationService == null) {
            modelTransformationService = new DefaultModelTransformationService();
        }
        return modelTransformationService;
    }

    private static ModelValidationService modelValidationService;
    public static ModelValidationService getModelValidationService() {
        if (modelValidationService == null) {
            modelValidationService = new DefaultModelValidationService();
        }
        return modelValidationService;
    }

    private static ProjectService projectService;
    public static ProjectService getProjectService() {
        if (projectService == null) {
            projectService = new DefaultProjectService(
                    getPathService(),
                    getJsonSerializerService(),
                    getGitService(),
                    getModelTransformationService(),
                    getModelValidationService()
            );
        }
        return projectService;
    }

    private static CredentialsProvider testCredentialsProvider;
    public static CredentialsProvider getTestCredentialsProvider() {
        if (testCredentialsProvider == null) {
            testCredentialsProvider = new UsernamePasswordCredentialsProvider(
                    getGitPropertiesService().getUsername(),
                    getGitPropertiesService().getPassword());
        }
        return testCredentialsProvider;
    }

    private static Path testPath;
    public static Path getTestPath() { return testPath; }

    private static Path unitTestPath;

    private static Path jGitRepositoryPath;
    public static Path getjGitRepositoryPath() { return jGitRepositoryPath; }

    private static Path jGitCommonModelFilePath;

    public static Path getJGitCommonModelFilePath() {
        return jGitCommonModelFilePath;
    }

    private static Path testReqifWorkingFilePath;
    public static Path getTestReqifWorkingFilePath() {
        return testReqifWorkingFilePath;
    }

    private static Path testSysmlWorkingFilePath;
    public static Path getTestSysmlWorkingFilePath() {
        return testSysmlWorkingFilePath;
    }

    private static Path testXlsxWorkingFilePath;
    public static Path getTestXlsxWorkingFilePath() {
        return testXlsxWorkingFilePath;
    }

    private static Path validateReqifWorkingFilePath;
    public static Path getValidateReqifWorkingFilePath() {
        return validateReqifWorkingFilePath;
    }

    private static Path exportReqifFilePath;
    public static Path getExportReqifFilePath() {
        return exportReqifFilePath;
    }

    private static Path exportXlsxFilePath;
    public static Path getExportXlsxFilePath() {
        return exportXlsxFilePath;
    }

    private static Path exportSysmlFilePath;
    public static Path getExportSysmlFilePath() {
        return exportSysmlFilePath;
    }

    private static Path oneRequirementReqifWorkingFilePath;
    public static Path getOneRequirementReqifWorkingFilePath() {
        return oneRequirementReqifWorkingFilePath;
    }

    private static Path oneRequirementSysmlWorkingFilePath;
    public static Path getOneRequirementSysmlWorkingFilePath() {
        return oneRequirementSysmlWorkingFilePath;
    }

    private static Path oneRequirementXlsxWorkingFilePath;
    public static Path getOneRequirementXlsxWorkingFilePath() {
        return oneRequirementXlsxWorkingFilePath;
    }

    private static String remoteRepositoryName;
    public static String getRemoteRepositoryName() { return remoteRepositoryName; }

    public static URI getRemoteRepositoryURI() {
        return URI.create(getRemoteRepositoryName());
    }

    static {
        testPath = getPathService().getPathOfRunningJar().resolve("test");
        unitTestPath = getPathService().getPathOfRunningJar().resolve("unitTest");

        //TODO: missing file oneRequirementXlsxWorkingFilePath
        oneRequirementReqifWorkingFilePath = unitTestPath.resolve("OneRequirementWorkingFile.reqif");
        oneRequirementSysmlWorkingFilePath = unitTestPath.resolve("OneRequirementWorkingFile.uml");
        oneRequirementXlsxWorkingFilePath = unitTestPath.resolve("OneRequirementWorkingFile.xlsx");

        jGitRepositoryPath = testPath.resolve("jGit_" + TEST_PROJECT_NAME);
        jGitCommonModelFilePath = jGitRepositoryPath.resolve("data.cm");

        testReqifWorkingFilePath = testPath.resolve("TestWorkingFile.reqif");
        testSysmlWorkingFilePath = testPath.resolve("TestWorkingFile.uml");
        testXlsxWorkingFilePath = testPath.resolve("TestWorkingFile.xlsx");

        exportReqifFilePath = testPath.resolve("Export.reqif");
        exportSysmlFilePath = testPath.resolve("Export.uml");
        exportXlsxFilePath = testPath.resolve("Export.xlsx");

        validateReqifWorkingFilePath = testPath.resolve("ValidateWorkingFile.reqif");

        remoteRepositoryName = "https://github.com/cfengler/proj-sqe-sose18-unittest.git";
    }

    public static boolean clearRemoteRepository() {
        try {
            FileUtils.deleteDirectory(jGitRepositoryPath.toFile());

            try (Git git = Git.cloneRepository()
                    .setURI(remoteRepositoryName)
                    .setDirectory(jGitRepositoryPath.toFile())
                    .call())
            {
                if (Files.deleteIfExists(jGitCommonModelFilePath)) {
                    git.rm().addFilepattern(".").call();
                    git.commit().setAll(true).setMessage("UnitTestHelper.clearRemoteRepository()").call();
                    git.push().setPushAll().setCredentialsProvider(getTestCredentialsProvider()).call();
                }
            }

            FileUtils.deleteDirectory(jGitRepositoryPath.toFile());

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean cloneLocalRepository() {
        try (Git git = Git.cloneRepository()
                .setURI(remoteRepositoryName)
                .setDirectory(jGitRepositoryPath.toFile())
                .call()) {

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean addProjectToRemoteRepository(Path reqifFilePath) {
        try {
            FileUtils.deleteDirectory(jGitRepositoryPath.toFile());

            try (Git git = Git.cloneRepository()
                    .setURI(remoteRepositoryName)
                    .setDirectory(jGitRepositoryPath.toFile())
                    .call()) {
                getModelTransformationService().transform(reqifFilePath, jGitCommonModelFilePath);
                git.add().addFilepattern(".").call();
                git.commit().setAll(true).setMessage("UnitTestHelper.addProjectToRemoteRepository()").call();
                git.push().setPushAll().setCredentialsProvider(getTestCredentialsProvider()).call();
            }

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean modifyRemoteRepository() {
        //TODO: implement correctly
        if (!jGitCommonModelFilePath.toFile().exists()) {
            return false;
        }

        if (!modifyReqifAddRequirement(jGitCommonModelFilePath, NEW_REQUIREMENT_DESCRIPTION_1)) {
            return false;
        }

        try {
            try (Git git = Git.open(jGitRepositoryPath.toFile())) {
                git.commit().setAll(true).setMessage("DefaultProjectServiceTest.modifyRemoteRepository()").call();
                git.push().setPushAll().setCredentialsProvider(getTestCredentialsProvider()).call();
            }

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteLocalRepository() {
        try {
            FileUtils.deleteDirectory(jGitRepositoryPath.toFile());
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

//    public static void main(String[] args) {
//
//        Path testReqifFilePath = getTestPath().resolve("test.reqif");
//
//        try {
//            FileUtils.copyFile(getOneRequirementReqifWorkingFilePath().toFile(), testReqifFilePath.toFile());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static boolean modifyReqifAddRequirement(Path reqifFilePath, String newDescription) {
        if (!reqifFilePath.toFile().exists()) {
            return false;
        }

        try {
            ReqIF10FactoryImpl reqIF10FactoryImpl = new ReqIF10FactoryImpl();
            ReqIF reqIFModel = DefaultModelService.getReqIFModel(reqifFilePath.toFile());

            SpecObjectType specObjectType = null;
            for (SpecType specType: reqIFModel.getCoreContent().getSpecTypes()) {
                if (specType instanceof SpecObjectType) {
                    specObjectType = (SpecObjectType) specType;
                    break;
                }
            }

            AttributeValueString newAttributeValue = reqIF10FactoryImpl.createAttributeValueString();
            newAttributeValue.setDefinition((AttributeDefinitionString) specObjectType.getSpecAttributes().get(0));
            newAttributeValue.setTheValue(newDescription);

            SpecObject specObject = reqIF10FactoryImpl.createSpecObject();
            specObject.setType(specObjectType);
            specObject.getValues().add(newAttributeValue);

            SpecHierarchy specHierarchy = reqIF10FactoryImpl.createSpecHierarchy();
            specHierarchy.setObject(specObject);
            reqIFModel.getCoreContent().getSpecifications().get(0).getChildren().add(specHierarchy);

            reqIFModel.getCoreContent().getSpecObjects().add(specObject);

            DefaultModelService.saveReqifModel(reqIFModel, reqifFilePath);

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean modifyReqifChangeRequirement(Path reqifFilePath, String newDescription) {
        if (!reqifFilePath.toFile().exists()) {
            return false;
        }

        ReqIF reqIFModel = DefaultModelService.getReqIFModel(reqifFilePath.toFile());

        ((AttributeValueString) reqIFModel.getCoreContent().getSpecObjects().get(0).getValues().get(0)).setTheValue(newDescription);

        DefaultModelService.saveReqifModel(reqIFModel, reqifFilePath);

        return true;
    }

    public static boolean modifyReqifFilesWithoutConflicts(Path firstReqifFilePath, Path secondReqifFilePath) {
        if (!firstReqifFilePath.toFile().exists() || !secondReqifFilePath.toFile().exists()) {
            return false;
        }

        if (!modifyReqifAddRequirement(firstReqifFilePath, NEW_REQUIREMENT_DESCRIPTION_1)) {
            return false;
        }

        if (!modifyReqifAddRequirement(secondReqifFilePath, NEW_REQUIREMENT_DESCRIPTION_2)) {
            return false;
        }

        return true;
    }

    public static boolean modifyReqifFilesWithConflicts(Path firstReqifFilePath, Path secondReqifFilePath) {
        if (!firstReqifFilePath.toFile().exists() || !secondReqifFilePath.toFile().exists()) {
            return false;
        }

        if (!modifyReqifChangeRequirement(firstReqifFilePath, CHANGED_REQUIREMENT_DESCRIPTION_1)) {
            return false;
        }
        if (!modifyReqifChangeRequirement(secondReqifFilePath, CHANGED_REQUIREMENT_DESCRIPTION_2)) {
            return false;
        }

        return true;
    }

    public static boolean copyFiles(Path source, Path destination) {
        try {
            Files.copy(source, destination);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
