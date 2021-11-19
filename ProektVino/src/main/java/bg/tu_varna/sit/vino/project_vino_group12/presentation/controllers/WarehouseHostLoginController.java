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

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.OPERATOR_VIEW;
import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.WAREHOUSEHOST_VIEW;

public class WarehouseHostLoginController {
    private boolean log=false;
    private final WarehouseHostService service= WarehouseHostService.getInstance();
    @FXML
    public Label warehouseHostlogin;
    @FXML
    public TextField warehouseHost_name;
    @FXML
    public PasswordField warehouseHost_pass;
    @FXML
    public Button login;
    @FXML
    public void onWarehouseHostLoginButtonClick(ActionEvent actionEvent){
        WarehouseHostListViewModel warehouseHostToLogIn=new WarehouseHostListViewModel(warehouseHost_name.getText(),warehouseHost_pass.getText());
      service.hostLogin(warehouseHostToLogIn);
    }
}
