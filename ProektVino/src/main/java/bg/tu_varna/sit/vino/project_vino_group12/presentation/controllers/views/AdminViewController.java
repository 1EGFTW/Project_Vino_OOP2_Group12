package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.AdminService;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.OperatorService;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.WarehouseHostService;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.HelloController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add.*;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.check.CheckBottlesController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.check.CheckGrapesController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.check.CheckWinesController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.create.CreateAdminController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.create.CreateOperatorController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.create.CreateWarehouseHostController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.delete.DeleteAdminController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.delete.DeleteOperatorController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.delete.DeleteWarehouseHostController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.*;

public class AdminViewController implements Initializable {
    AdminService adminService=AdminService.getInstance();
    OperatorService operatorService=OperatorService.getInstance();
    WarehouseHostService warehouseHostService=WarehouseHostService.getInstance();
    Stage s;
    @FXML
    public Button addGrape;
    @FXML
    public Button addBottles;
    @FXML
    private Label create;
   @FXML
    private Button createOperator;
   @FXML
    private Button createHost;
    @FXML
    private Button createAdmin;
    @FXML
    private Button checkAvailableGrapes;
    @FXML
    private Button checkAvailableBottles;
    @FXML
    private Button checkAvailableWines;
    @FXML
    private Label delete;
    @FXML
    private ComboBox<String> comboBoxDelete;
    @FXML
    private Button deleteChoice;

    public AdminViewController(Stage s){

        this.s=s;
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
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
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
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
   }
    @FXML
    protected void createAdmin(ActionEvent actionEvent) {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CREATE_ADMIN));
            Stage stage = new Stage();
            fxmlLoader.setController(new CreateAdminController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
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
            case "Admin":
                try {
                    s.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(DELETE_ADMIN));
                    Stage stage = new Stage();
                    fxmlLoader.setController(new DeleteAdminController(stage));
                    Parent root1 = (Parent) fxmlLoader.load();
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Operator":
                try {
                    s.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(DELETE_OPERATOR));
                    Stage stage = new Stage();
                    fxmlLoader.setController(new DeleteOperatorController(stage));
                    Parent root1 = (Parent) fxmlLoader.load();
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Warehouse Host":
                try {
                    s.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(DELETE_HOST));
                    Stage stage = new Stage();
                    fxmlLoader.setController(new DeleteWarehouseHostController(stage));
                    Parent root1 = (Parent) fxmlLoader.load();
                    stage.setScene(new Scene(root1));
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
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        notificationAlerts();
        fillComboBox();
    }
    private void notificationAlerts(){
        AdminService adminService=AdminService.getInstance();
        List<String> bottles = adminService.checkAvailableBottles();
        List<String> grapes=adminService.checkAvailableGrapes();
        for (String s:bottles){
            Alert alert=new Alert(Alert.AlertType.WARNING,"Please check availability:\nBottle: "+s+"ml",ButtonType.OK);
            alert.show();
        }
        for (String s:grapes){
            Alert alert=new Alert(Alert.AlertType.WARNING,"Please check availability:\nGrape: "+s,ButtonType.OK);
            alert.show();
        }
    }
    private void fillComboBox(){
        List<String> choices=new ArrayList<>();
        choices.add("Admin");
        choices.add("Operator");
        choices.add("Warehouse Host");
        comboBoxDelete.setItems(FXCollections.observableList(choices));
    }


}
