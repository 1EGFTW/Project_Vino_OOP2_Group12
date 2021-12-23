package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.AdminService;
import bg.tu_varna.sit.vino.project_vino_group12.common.Constants;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.HelloController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add.AddBottlesController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add.AddGrapeController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add.AddSortColorController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.check.CheckBottlesController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.check.CheckGrapesController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.check.CheckWinesController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.create.CreateWarehouseHostController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.delete.*;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.update.UpdateBottlesController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.update.UpdateGrapeController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.*;

public class WarehouseHostViewController implements Initializable {
    Stage s;
    @FXML
    public Pane wrapperPane;
    @FXML
    public Pane addPane;
    @FXML
    public Pane checkPane;
    @FXML
    public Pane deletePane;
    @FXML
    public Pane updatePane;
    @FXML
    public Button changeToCreate;
    @FXML
    public Button changeToAdd;
    @FXML
    public Button changeToCheck;
    @FXML
    public Button changeToDelete;
    @FXML
    public Button changeToUpdate;
    @FXML
    public Button addGrape;
    @FXML
    public Button addBottles;
    @FXML
    private Button createHost;
    @FXML
    private Button checkAvailableGrapes;
    @FXML
    private Button checkAvailableBottles;
    @FXML
    private Button checkAvailableWines;
    @FXML
    private ComboBox<String> comboBoxDelete;
    @FXML
    private Button deleteChoice;
    @FXML
    private Button notifications;
    @FXML
    public Label label;
    @FXML
    public Label user;
    @FXML
    public Button bottle;
    @FXML
    public Button grape;
    @FXML
    public Button wine;
    @FXML
    public Button back;

    public WarehouseHostViewController(Stage stage) {
        this.s=stage;
    }

    @FXML
    protected void createHost(ActionEvent event){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CREATE_WAREHOUSEHOST));
            Stage stage = new Stage();
            fxmlLoader.setController(new CreateWarehouseHostController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addGrape(ActionEvent actionEvent) {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADD_GRAPE));
            Stage stage = new Stage();
            fxmlLoader.setController(new AddGrapeController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void addBottles(ActionEvent actionEvent) {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADD_BOTTLES));
            Stage stage = new Stage();
            fxmlLoader.setController(new AddBottlesController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void addSortColor(ActionEvent actionEvent){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADD_SORTCOLOR));
            Stage stage = new Stage();
            fxmlLoader.setController(new AddSortColorController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void checkAvailableGrapes(ActionEvent actionEvent){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CHECK_GRAPES));
            Stage stage = new Stage();
            fxmlLoader.setController(new CheckGrapesController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void checkAvailableBottles(ActionEvent actionEvent){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CHECK_BOTTLES));
            Stage stage = new Stage();
            fxmlLoader.setController(new CheckBottlesController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void checkAvailableWines(ActionEvent actionEvent){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CHECK_WINES));
            Stage stage = new Stage();
            fxmlLoader.setController(new CheckWinesController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goBack(ActionEvent actionEvent){
        loadNewPage(HELLO_VIEW);
    }

    @FXML
    public void deleteSelected(ActionEvent actionEvent){
        switch (comboBoxDelete.getValue())
        {
            case "Bottle":
                try {
                    s.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(DELETE_BOTTLE));
                    Stage stage = new Stage();
                    fxmlLoader.setController(new DeleteBottleController(stage));
                    Parent root1 = (Parent) fxmlLoader.load();
                    stage.setScene(new Scene(root1));
                    stage.setResizable(false);
                    stage.show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Wine":
                try {
                    s.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(DELETE_WINE));
                    Stage stage = new Stage();
                    fxmlLoader.setController(new DeleteWineController(stage));
                    Parent root1 = (Parent) fxmlLoader.load();
                    stage.setScene(new Scene(root1));
                    stage.setResizable(false);
                    stage.show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Grape":
                try {
                    s.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(DELETE_GRAPE));
                    Stage stage = new Stage();
                    fxmlLoader.setController(new DeleteGrapeController(stage));
                    Parent root1 = (Parent) fxmlLoader.load();
                    stage.setScene(new Scene(root1));
                    stage.setResizable(false);
                    stage.show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
                break;
            case "SortColor":
                try {
                    s.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(DELETE_SORTCOLOR));
                    Stage stage = new Stage();
                    fxmlLoader.setController(new DeleteSortColorController(stage));
                    Parent root1 = (Parent) fxmlLoader.load();
                    stage.setScene(new Scene(root1));
                    stage.setResizable(false);
                    stage.show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    private void loadNewPage(String path){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
            Stage stage = new Stage();
            fxmlLoader.setController(new HelloController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillComboBox();
        user.setText(Constants.User.LoggedUser);
    }

    @FXML
    protected void checkNotifications(ActionEvent actionEvent){
        notificationAlerts();
    }

    private void notificationAlerts(){
        AdminService adminService=AdminService.getInstance();
        List<String> bottles = adminService.checkAvailableBottles();
        List<String> grapes=adminService.checkAvailableGrapes();
        for (String s:bottles){
            Alert alert=new Alert(Alert.AlertType.WARNING,"Please check availability:\nBottle: "+s+"ml", ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add("Alerts.css");
            dialogPane.getStyleClass().add("Alert");
            alert.show();
        }
        for (String s:grapes){
            Alert alert=new Alert(Alert.AlertType.WARNING,"Please check availability:\nGrape: "+s,ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add("Alerts.css");
            dialogPane.getStyleClass().add("Alert");
            alert.show();
        }
        if(bottles.isEmpty() && grapes.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Everything is in stock!",ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add("Alerts.css");
            dialogPane.getStyleClass().add("Alert");
            alert.show();
        }
    }

    private void fillComboBox(){
        List<String> choices=new ArrayList<>();
        choices.add("Bottle");
        choices.add("Wine");
        choices.add("Grape");
        choices.add("SortColor");
        comboBoxDelete.setItems(FXCollections.observableList(choices));
    }

    @FXML
    public void updateBottles(ActionEvent actionEvent){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(UPDATE_BOTTLES));
            Stage stage = new Stage();
            fxmlLoader.setController(new UpdateBottlesController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void updateGrape(ActionEvent actionEvent){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(UPDATE_GRAPE));
            Stage stage = new Stage();
            fxmlLoader.setController(new UpdateGrapeController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void changeToAdd(ActionEvent actionEvent){
        wrapperPane.getChildren().clear();
        wrapperPane.getChildren().add(addPane);
    }

    @FXML
    public void changeToCheck(ActionEvent actionEvent){
        wrapperPane.getChildren().clear();
        wrapperPane.getChildren().add(checkPane);
    }

    @FXML
    public void changeToDelete(ActionEvent actionEvent){
        wrapperPane.getChildren().clear();
        wrapperPane.getChildren().add(deletePane);
    }

    @FXML
    public void changeToUpdate(ActionEvent actionEvent){
        wrapperPane.getChildren().clear();
        wrapperPane.getChildren().add(updatePane);
    }
}
