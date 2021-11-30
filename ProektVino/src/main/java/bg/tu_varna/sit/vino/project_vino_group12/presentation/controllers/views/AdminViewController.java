package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.AdminService;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.GrapeService;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.HelloController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add.*;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.check.CheckBottlesController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.check.CheckGrapesController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.check.CheckWinesController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.create.CreateAdminController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.create.CreateOperatorController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.create.CreateWarehouseHostController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.GrapeListViewModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.*;

public class AdminViewController implements Initializable {
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
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(HELLO_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new HelloController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void loadNewPage(String path){
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
    }
    public void notificationAlerts(){
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
}
