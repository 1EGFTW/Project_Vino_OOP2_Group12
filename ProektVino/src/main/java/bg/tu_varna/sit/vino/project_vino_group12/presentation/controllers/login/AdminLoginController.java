package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.login;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.AdminService;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.AdminListViewModel;
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

public class AdminLoginController {
    private final AdminService service=AdminService.getInstance();
    public Stage s;
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
                Stage stage = new Stage();
                fxmlLoader.setController(new AdminViewController(stage));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
