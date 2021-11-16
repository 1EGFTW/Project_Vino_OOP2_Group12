package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.BottlesRepository;
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
    protected void createOperator(ActionEvent event){
       try {
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CREATE_OPERATOR));
           Parent root1 = (Parent) fxmlLoader.load();
           Stage stage = new Stage();
           stage.setScene(new Scene(root1));
           stage.show();
       } catch(Exception e) {
           e.printStackTrace();
       }

   }
   @FXML
    protected void createHost(ActionEvent event){
       try {
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CREATE_WAREHOUSEHOST));
           Parent root1 = (Parent) fxmlLoader.load();
           Stage stage = new Stage();
           stage.setScene(new Scene(root1));
           stage.show();
       } catch(Exception e) {
           e.printStackTrace();
       }
   }

    @FXML
    public void createAdmin(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CREATE_ADMIN));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void addGrape(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADD_GRAPE));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void addBottles(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADD_BOTTLES));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }


    }
}
