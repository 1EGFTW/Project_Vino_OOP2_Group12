package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Admin;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.AdminRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateAdminController {
    private final AdminRepository repository=AdminRepository.getInstance();
    @FXML
    public Label createAdmin;
    @FXML
    public PasswordField admin_pass;
    @FXML
    public TextField admin_name;
    @FXML
    public Button login;
    @FXML
    public void onCreateAdminButtonClick(ActionEvent actionEvent) {
        Admin a=new Admin();
        a.setUsername_admin(admin_name.toString());
        a.setPassword_admin(admin_pass.toString());
        try{
            repository.save(a);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
