package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.AdminService;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.OperatorService;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.WarehouseHostService;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.HelloController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add.AddProductionController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add.AddWineController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.check.CheckBottlesController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.check.CheckGrapesController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.check.CheckProductionController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.check.CheckWinesController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.create.CreateOperatorController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.delete.*;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.update.UpdateWineController;
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

public class OperatorViewController implements Initializable {
    Stage s;
    private final AdminService adminService=AdminService.getInstance();
    private final OperatorService operatorService=OperatorService.getInstance();
    private final WarehouseHostService warehouseHostService=WarehouseHostService.getInstance();

    @FXML
    public Pane wrapperPane;
    @FXML
    public Pane createPane;
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
    private Button createOperator;
    @FXML
    private Button checkAvailableGrapes;
    @FXML
    private Button checkAvailableBottles;
    @FXML
    private Button checkAvailableWines;
    @FXML
    private Button checkAvailableProductions;
    @FXML
    private Label delete;
    @FXML
    private ComboBox<String> comboBoxDelete;
    @FXML
    private Button deleteChoice;
    @FXML
    private Button notifications;
    @FXML
    public Button back;

    public OperatorViewController(Stage stage) {
        this.s=stage;
    }

    @FXML
    protected void createOperator(ActionEvent event){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CREATE_OPERATOR));
            Stage stage = new Stage();
            fxmlLoader.setController(new CreateOperatorController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addWines(ActionEvent actionEvent) {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADD_WINE));
            Stage stage = new Stage();
            fxmlLoader.setController(new AddWineController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void addProduction(ActionEvent actionEvent) {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADD_PRODUCTION));
            Stage stage = new Stage();
            fxmlLoader.setController(new AddProductionController(stage));
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
    public void checkAvailableProductions(ActionEvent actionEvent){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CHECK_PRODUCTION));
            Stage stage = new Stage();
            fxmlLoader.setController(new CheckProductionController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void deleteSelected(ActionEvent actionEvent){
        switch (comboBoxDelete.getValue())
        {
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
            case "Production":
                try {
                    s.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(DELETE_PRODUCTION));
                    Stage stage = new Stage();
                    fxmlLoader.setController(new DeleteProductionController(stage));
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillComboBox();
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
            alert.show();
        }
        for (String s:grapes){
            Alert alert=new Alert(Alert.AlertType.WARNING,"Please check availability:\nGrape: "+s,ButtonType.OK);
            alert.show();
        }
        if(bottles.isEmpty() && grapes.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Everything is in stock!",ButtonType.OK);
            alert.show();
        }
    }
    private void fillComboBox(){
        List<String> choices=new ArrayList<>();
        choices.add("Wine");
        choices.add("Production");
        comboBoxDelete.setItems(FXCollections.observableList(choices));
    }

    @FXML
    public void updateWine(ActionEvent actionEvent){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(UPDATE_WINE));
            Stage stage = new Stage();
            fxmlLoader.setController(new UpdateWineController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void changeToCreate(ActionEvent actionEvent){
        wrapperPane.getChildren().clear();
        wrapperPane.getChildren().add(createPane);
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

    @FXML
    public void goBack(ActionEvent actionEvent){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(HELLO_VIEW));
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
}
