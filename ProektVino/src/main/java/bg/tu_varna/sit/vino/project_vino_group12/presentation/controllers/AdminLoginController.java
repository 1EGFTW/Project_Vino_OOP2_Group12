package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.AdminService;
import bg.tu_varna.sit.vino.project_vino_group12.common.Constants;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.AdminRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.AdminListViewModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;

public class AdminLoginController {
    private final AdminService service=AdminService.getInstance();
    URL path = getClass().getResource(Constants.View.ADMIN_VIEW);
    Parent root;

    private boolean log=false;
    @FXML
    public Label adminlogin;
    @FXML
    public TextField admin_name;
    @FXML
    public PasswordField admin_pass;
    @FXML
    public Button login;
    @FXML
    public void onLoginButtonClick() {
        AdminListViewModel adminToLogIn=new AdminListViewModel(admin_pass.getText(),admin_pass.getText());
        ObservableList<AdminListViewModel> allAdmins= service.getAllAdmin();
        for (AdminListViewModel a:allAdmins)
        {
            if(a.equals(adminToLogIn))
            {
                log=true;
            }
        }
        if(log)
        {
            {
                try {
                    root = FXMLLoader.load(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Scene adminView=new Scene(root);
        }
    }





}
