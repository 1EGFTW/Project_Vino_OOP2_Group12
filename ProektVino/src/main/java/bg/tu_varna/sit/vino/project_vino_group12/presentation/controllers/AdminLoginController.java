package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.AdminService;
import bg.tu_varna.sit.vino.project_vino_group12.common.Constants;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.AdminRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.AdminListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.OperatorListViewModel;
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

import java.io.IOException;
import java.net.URL;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.ADMIN_VIEW;

public class AdminLoginController {
    private final AdminService service=AdminService.getInstance();
    public Stage s;
    private boolean log=false;
    @FXML
    public Label adminlogin;
    @FXML
    public TextField admin_name;
    @FXML
    public PasswordField admin_pass;
    @FXML
    public Button login;
    public AdminLoginController(Stage stage){
        s=stage;
    }
    @FXML
    public void onAdminLoginButtonClick(ActionEvent actionEvent) {
        AdminListViewModel adminToLogIn=new AdminListViewModel(admin_name.getText(),admin_pass.getText());
        service.adminLogin(adminToLogIn);
        if(service.adminLogin(adminToLogIn))
        {
            try {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADMIN_VIEW));
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
