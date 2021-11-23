package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.HelloController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add.AddBottlesController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add.AddGrapeController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add.AddSortColorController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.create.CreateAdminController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.create.CreateOperatorController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.create.CreateWarehouseHostController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.*;

public class AdminViewController{
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
    public AdminViewController(Stage s){
        this.s=s;
    }
   @FXML
    protected void createOperator(ActionEvent event){
       try {
           s.close();
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CREATE_OPERATOR));
           Stage stage=new Stage();
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
}
