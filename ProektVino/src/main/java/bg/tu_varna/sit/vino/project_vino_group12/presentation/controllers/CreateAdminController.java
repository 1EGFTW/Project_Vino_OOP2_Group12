package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Admin;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Operator;
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
    public void onCreateAdminButtonClick(ActionEvent actionEvent) { //da se pogledne zashto kato se pusne tazi funkciq ne trygva repositorito
    //sled tazi funkciq se syzdawa i constructor v admin po syshtiq nachin kakto w operator i warehousehost, no pri tqh raboti
        Admin admin=new Admin(admin_name.getText().toString(),admin_pass.getText().toString());
        try{
            repository.save(admin);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}
