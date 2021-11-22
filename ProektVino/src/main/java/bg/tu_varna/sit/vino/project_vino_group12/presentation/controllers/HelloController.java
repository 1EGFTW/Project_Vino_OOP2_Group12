package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.AdminService;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.login.AdminLoginController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.login.OperatorLoginController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.login.WarehouseHostLoginController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.AdminListViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.*;

public class HelloController {
    private final AdminService service=AdminService.getInstance();
    Stage s=new Stage();
    @FXML
    private Label HelloText;

    @FXML
    private Button adminButton;
    @FXML
    private Button operatorButton;
    @FXML
    private Button warehouseHostButton;
    @FXML
    private ListView<AdminListViewModel> listView;


    public HelloController(Stage stage){
        s=stage;
    }
    @FXML
    protected void adminLog() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADMIN_LOGIN));
            Stage stage = new Stage();
            fxmlLoader.setController(new AdminLoginController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void operatorLog(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(OPERATOR_LOGIN));
            Stage stage = new Stage();
            fxmlLoader.setController(new OperatorLoginController(stage));
            Parent root1 = (Parent) fxmlLoader.load();

            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void warehouseHostLog(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(WAREHOUSEHOST_LOGIN));
            Stage stage = new Stage();
            fxmlLoader.setController(new WarehouseHostLoginController(stage));
            Parent root1 = (Parent) fxmlLoader.load();

            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}