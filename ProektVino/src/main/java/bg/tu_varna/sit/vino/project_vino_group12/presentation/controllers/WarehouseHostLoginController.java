package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.OperatorService;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.WarehouseHostService;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.OperatorListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.WarehouseHostListViewModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.*;

public class WarehouseHostLoginController {
    Stage s;
    private final WarehouseHostService service= WarehouseHostService.getInstance();
    @FXML
    public Label warehouseHostlogin;
    @FXML
    public TextField warehouseHost_name;
    @FXML
    public PasswordField warehouseHost_pass;
    @FXML
    public Button login;

    public WarehouseHostLoginController(Stage stage) {
        s=stage;
    }

    @FXML
    public void onWarehouseHostLoginButtonClick(ActionEvent actionEvent){
        WarehouseHostListViewModel warehouseHostToLogIn=new WarehouseHostListViewModel(warehouseHost_name.getText(),warehouseHost_pass.getText());
      if(service.hostLogin(warehouseHostToLogIn)){
          try {
              s.close();
              FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(WAREHOUSEHOST_VIEW));
              Parent root1 = (Parent) fxmlLoader.load();
              Stage stage = new Stage();
              stage.setScene(new Scene(root1));
              stage.show();
          } catch(Exception e) {
              e.printStackTrace();
          }
      }
    }
}
