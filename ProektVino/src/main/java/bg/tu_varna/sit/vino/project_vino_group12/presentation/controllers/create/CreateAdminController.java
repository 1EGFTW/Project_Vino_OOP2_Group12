package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.create;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.AdminService;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Admin;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.HelloController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
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

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.ADMIN_VIEW;
import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.HELLO_VIEW;

public class CreateAdminController {
    private final AdminService service=AdminService.getInstance();
    Stage s;
    @FXML
    public Label createAdmin;
    @FXML
    public PasswordField admin_pass;
    @FXML
    public TextField admin_name;
    @FXML
    public Button login;

    public CreateAdminController(Stage stage) {
        this.s=stage;
    }

    @FXML
    public void onCreateAdminButtonClick(ActionEvent actionEvent) {
        Admin admin=new Admin(admin_name.getText(),admin_pass.getText());
        service.createAdmin(admin);
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADMIN_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new AdminViewController(stage));
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADMIN_VIEW));
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
