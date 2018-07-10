package de.tuberlin.sqe.ss18.reqexchange.view.controller;

import com.google.inject.Inject;
import de.tuberlin.sqe.ss18.reqexchange.git.GitPropertiesService;
import de.tuberlin.sqe.ss18.reqexchange.project.Project;
import de.tuberlin.sqe.ss18.reqexchange.project.ReqExchangeFileType;
import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.ClientViewModel;
import de.tuberlin.sqe.ss18.reqexchange.view.viewmodel.ProjectViewModel;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.util.Pair;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ClientController {

    @FXML private HBox hBoxActions;
    @FXML private Button buttonCreateProject;
    @FXML private Button buttonJoinProject;
    @FXML private Button buttonSettings;
    @FXML private FlowPane flowPaneProjects;
    @FXML private ScrollPane scrollPaneProjects;
    @FXML private ProgressIndicator progressIndicator;
    @FXML private ImageView imageLogo;

    private ClientViewModel clientViewModel;
    private GitPropertiesService gitPropertiesService;

    @Inject
    public ClientController(ClientViewModel clientViewModel, GitPropertiesService gitPropertiesService) {
        System.out.println(getClass().getSimpleName() + " ctor");

        this.clientViewModel = clientViewModel;
        this.gitPropertiesService = gitPropertiesService;
    }

    @FXML
    public void initialize() {
        imageLogo.setImage(new Image(getClass().getResourceAsStream("/images/Logo_ReqExchange.png")));
        imageLogo.fitHeightProperty().bind(buttonCreateProject.heightProperty());
        BorderPane.setMargin(imageLogo, new Insets(5));
        BorderPane.setMargin(progressIndicator, new Insets(20));
        flowPaneProjects.prefWrapLengthProperty().bind(scrollPaneProjects.widthProperty());
        clientViewModel.getProjects().forEach(this::addProjectInfoController);
        clientViewModel.getProjects().addListener((ListChangeListener<? super ProjectViewModel>) c -> {
            c.next();
            c.getRemoved().forEach(projectInfoViewModel -> {
                flowPaneProjects.getChildren().removeIf(project -> ((ProjectInfoController)project).getProjectViewModel().equals(projectInfoViewModel));
            });
            c.getAddedSubList().forEach(this::addProjectInfoController);
        });
        clientViewModel.busyProperty().bindBidirectional(progressIndicator.visibleProperty());
        clientViewModel.busyProperty().bindBidirectional(buttonCreateProject.disableProperty());
        clientViewModel.busyProperty().bindBidirectional(buttonJoinProject.disableProperty());
        clientViewModel.busyProperty().bindBidirectional(buttonSettings.disableProperty());

        //TODO Testdaten entfernen
        //addTestProjects();
    }

    private void addProjectInfoController(ProjectViewModel projectViewModel) {
        ProjectInfoController newController = new ProjectInfoController(projectViewModel, clientViewModel);
        FlowPane.setMargin(newController, new Insets(10));
        calculateControllerWidth(newController, scrollPaneProjects.getWidth());
        scrollPaneProjects.widthProperty().addListener(((observable, oldValue, newValue) -> {
            calculateControllerWidth(newController, newValue.doubleValue());
        }));
        flowPaneProjects.getChildren().add(newController);
    }

    private void calculateControllerWidth(ProjectInfoController controller, double width) {
        double paneWidth = controller.getMinWidth() + FlowPane.getMargin(controller).getRight() + FlowPane.getMargin(controller).getLeft();
        int panesInRow = (int) ((width) / paneWidth);
        double remaining = width % paneWidth;
        controller.setPrefWidth(controller.getMinWidth() + (remaining - 20) / panesInRow);
    }

    @FXML protected void handleButtonCreateProjectAction(ActionEvent event) {
        Dialog<Pair<Pair<String, String>, Pair<String, String>>> dialog = new Dialog<>();
        dialog.setTitle("Create Project");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        dialog.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/icons/icon_create_project.png"))));

        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        TextField name = new TextField();
        TextField gitpath = new TextField();
        //TODO password deactivated
        PasswordField password = new PasswordField();
        password.setDisable(true);
        password.setPromptText("disabled");
        PasswordField confirmPassword = new PasswordField();
        confirmPassword.setDisable(true);
        confirmPassword.setPromptText("disabled");
        //TODO Testdaten entfernen
        //name.setText("proj-sqe-sose18-test");
        //password.setText("a");
        //confirmPassword.setText("a");
        BorderPane border = new BorderPane();
        Button file = new Button("...");
        Label filename = new Label();
        file.setOnAction(fileEvent -> {
            filename.setMaxWidth(border.getBoundsInParent().getMinX());
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Choose ReqIF File");
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("ReqIF File", "*.reqif", "*.reqifz"));
            File chosen = chooser.showOpenDialog(grid.getScene().getWindow());
            if(chosen != null) {
                filename.setText(chosen.getAbsolutePath());
            }
        });
        border.setCenter(filename);
        border.setRight(file);
        Label error = new Label("Passwords do not match!");
        error.setTextFill(Color.RED);
        error.setVisible(false);
        grid.add(new Label("Project Name:"), 0, 0);
        grid.add(new Label("Git URL:"), 0, 1);
        grid.add(new Label("Password:"), 0, 2);
        grid.add(new Label("Confirm Password:"), 0, 3);
        grid.add(new Label("ReqIF File:"), 0, 4);
        grid.add(name, 1, 0);
        grid.add(gitpath, 1, 1);
        grid.add(password, 1, 2);
        grid.add(confirmPassword, 1, 3);
        grid.add(border, 1, 4);
        grid.add(error, 0, 5, 2, 1);
        for(Node n: grid.getChildren()) {
            GridPane.setHalignment(n, HPos.RIGHT);
        }
        Node ok = dialog.getDialogPane().lookupButton(ButtonType.OK);
        ok.setDisable(true);
        ChangeListener changeListener = (observable, oldValue, newValue) -> {
            //TODO password deactivated
            ok.setDisable(name.getText().equals("") /*|| password.getText().equals("")
                    || confirmPassword.getText().equals("")*/ || filename.getText().equals("") || gitpath.getText().equals(""));
        };
        name.textProperty().addListener(changeListener);
        gitpath.textProperty().addListener(changeListener);
        password.textProperty().addListener(changeListener);
        confirmPassword.textProperty().addListener(changeListener);
        filename.textProperty().addListener(changeListener);
        dialog.getDialogPane().setContent(grid);
        Platform.runLater(name::requestFocus);
        ok.addEventFilter(ActionEvent.ACTION, okEvent -> {
            if(!password.getText().equals(confirmPassword.getText())) {
                error.setVisible(true);
                okEvent.consume();
            }
        });
        dialog.setResultConverter(dialogButton -> {
            if(dialogButton == ButtonType.OK && password.getText().equals(confirmPassword.getText())) {
                return new Pair<>(new Pair<>(name.getText(), gitpath.getText()), new Pair<>(password.getText(), filename.getText()));
            }
            return null;
        });

        Optional<Pair<Pair<String, String>, Pair<String, String>>> result = dialog.showAndWait();
        result.ifPresent(triplet -> {
            clientViewModel.handleCreateProject(triplet.getKey().getValue(), triplet.getKey().getKey(), triplet.getValue().getKey(), triplet.getValue().getValue());
        });
    }

    @FXML protected void handleButtonSettingsAction(ActionEvent event) {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Settings");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        dialog.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/icons/icon_settings.png"))));

        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        TextField username = new TextField(gitPropertiesService.getUsername());
        PasswordField password = new PasswordField();
        password.setText(gitPropertiesService.getPassword());

        grid.add(new Label("Git Username:"), 0, 0);
        grid.add(new Label("Git Password:"), 0, 1);
        grid.add(username, 1, 0);
        grid.add(password, 1, 1);
        for(Node n: grid.getChildren()) {
            GridPane.setHalignment(n, HPos.RIGHT);
        }
        Node ok = dialog.getDialogPane().lookupButton(ButtonType.OK);
        ok.setDisable(username.getText().equals("") || password.getText().equals(""));
        ChangeListener changeListener = (observable, oldValue, newValue) -> {
            ok.setDisable(username.getText().equals("") || password.getText().equals(""));
        };
        username.textProperty().addListener(changeListener);
        password.textProperty().addListener(changeListener);
        dialog.getDialogPane().setContent(grid);
        Platform.runLater(username::requestFocus);

        dialog.setResultConverter(dialogButton -> {
            if(dialogButton == ButtonType.OK) {
                return new Pair<>(username.getText(), password.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();
        result.ifPresent(settings -> {
            gitPropertiesService.setUsername(settings.getKey());
            gitPropertiesService.setPassword(settings.getValue());
            gitPropertiesService.save();
        });
    }

    @FXML protected void handleButtonJoinProjectAction(ActionEvent event) {
        Dialog<Pair<Pair<Pair<String, String>, String>, Pair<ReqExchangeFileType, String>>> dialog = new Dialog<>();
        dialog.setTitle("Join Project");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        dialog.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/icons/icon_join_project.png"))));

        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        TextField name = new TextField();
        TextField gitpath = new TextField();
        PasswordField password = new PasswordField();
        //TODO password deactivated
        password.setDisable(true);
        password.setPromptText("disabled");
        ChoiceBox<ReqExchangeFileType> choice = new ChoiceBox<>();
        //TODO Testdaten entfernen
        //name.setText("proj-sqe-sose18-test");
        //password.setText("a");
        List<ReqExchangeFileType> choices = Arrays.asList(ReqExchangeFileType.values());
        choice.setItems(FXCollections.observableArrayList(choices));
        BorderPane border = new BorderPane();
        Button file = new Button("...");
        Label filename = new Label();
        file.setOnAction(fileEvent -> {
            filename.setMaxWidth(border.getBoundsInParent().getMinX());
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Save File As");
            ReqExchangeFileType filetype = choice.getSelectionModel().getSelectedItem();
            List<String> filetypeFilters = new ArrayList<>();
            for(String s: filetype.getFiletypes()) {
                filetypeFilters.add("*." + s);
            }
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(filetype.getName(), filetypeFilters));
            File chosen = chooser.showSaveDialog(grid.getScene().getWindow());
            if(chosen != null) {
                filename.setText(chosen.getAbsolutePath());
            }
        });
        border.setCenter(filename);
        border.setRight(file);
        grid.add(new Label("Project Name:"), 0, 0);
        grid.add(new Label("Git URL:"), 0, 1);
        grid.add(new Label("Password:"), 0, 2);
        grid.add(new Label("File Type:"), 0, 3);
        grid.add(new Label("Save File As:"), 0, 4);
        grid.add(name, 1, 0);
        grid.add(gitpath, 1, 1);
        grid.add(password, 1, 2);
        grid.add(choice, 1, 3);
        grid.add(border, 1, 4);
        for(Node n: grid.getChildren()) {
            GridPane.setHalignment(n, HPos.RIGHT);
        }
        Node ok = dialog.getDialogPane().lookupButton(ButtonType.OK);
        ok.setDisable(true);
        ChangeListener changeListener = (observable, oldValue, newValue) -> {
            //TODO password deactivated
            ok.setDisable(name.getText().equals("") || /*password.getText().equals("") ||*/
                    filename.getText().equals("") || choice.getSelectionModel().getSelectedIndex() == -1 || gitpath.getText().equals(""));
        };
        name.textProperty().addListener(changeListener);
        gitpath.textProperty().addListener(changeListener);
        password.textProperty().addListener(changeListener);
        choice.getSelectionModel().selectedItemProperty().addListener(changeListener);
        filename.textProperty().addListener(changeListener);
        file.disableProperty().bind(Bindings.equal(choice.getSelectionModel().selectedIndexProperty(), -1));
        dialog.getDialogPane().setContent(grid);
        Platform.runLater(name::requestFocus);
        dialog.setResultConverter(dialogButton -> {
            if(dialogButton == ButtonType.OK) {
                return new Pair<>(new Pair<>(new Pair<>(name.getText(), gitpath.getText()), password.getText()), new Pair<>(choice.getSelectionModel().getSelectedItem(), filename.getText()));
            }
            return null;
        });

        Optional<Pair<Pair<Pair<String, String>, String>, Pair<ReqExchangeFileType, String>>> result = dialog.showAndWait();
        result.ifPresent(pair -> {
            clientViewModel.handleJoinProject(pair.getKey().getKey().getValue(), pair.getKey().getKey().getKey(), pair.getKey().getValue(), pair.getValue().getKey(), pair.getValue().getValue());
        });
    }

    private void addTestProjects() {
        Project project1 = new Project();
        project1.setName("SQE Project");
        project1.setWorkingModelFilePath(Paths.get("testdatei.reqif"));
        ProjectViewModel viewModel1 = new ProjectViewModel(project1);
        viewModel1.setCanPull(true);
        viewModel1.setCanPush(false);
        addProjectInfoController(viewModel1);

        Project project2 = new Project();
        project2.setName("Top Secret");
        project2.setWorkingModelFilePath(Paths.get("testdatei.uml"));
        ProjectViewModel viewModel2 = new ProjectViewModel(project2);
        viewModel2.setCanPull(false);
        viewModel2.setCanPush(false);
        addProjectInfoController(viewModel2);

        Project project3 = new Project();
        project3.setName("Microsoft GitHub");
        project3.setWorkingModelFilePath(Paths.get("testdatei.xlsx"));
        ProjectViewModel viewModel3 = new ProjectViewModel(project3);
        viewModel3.setCanPull(true);
        viewModel3.setCanPush(true);
        addProjectInfoController(viewModel3);

        Project project4 = new Project();
        project4.setName("Trade Plans");
        project4.setWorkingModelFilePath(Paths.get("testdatei.docx"));
        ProjectViewModel viewModel4 = new ProjectViewModel(project4);
        viewModel4.setCanPull(false);
        viewModel4.setCanPush(true);
        addProjectInfoController(viewModel4);
    }
}