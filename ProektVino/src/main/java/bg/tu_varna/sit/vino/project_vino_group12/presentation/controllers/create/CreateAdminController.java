package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.create;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.AdminService;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Admin;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.HelloController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add.AddBottlesController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.AdminListViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.*;

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
        AdminListViewModel admin=new AdminListViewModel(admin_name.getText(),admin_pass.getText());
        int res=service.createAdmin(admin);
        if(res==0){
            try {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CREATE_ADMIN));
                Stage stage = new Stage();
                fxmlLoader.setController(new CreateAdminController(stage));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1));
                stage.setResizable(false);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Alert alert=new Alert(Alert.AlertType.WARNING,"Admin already exists!", ButtonType.CLOSE);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add("Alerts.css");
            dialogPane.getStyleClass().add("Alert");
            alert.show();
        }
        else{
            loadNewPage(ADMIN_VIEW);
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Admin added", ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add("Alerts.css");
            dialogPane.getStyleClass().add("Alert");
            alert.show();
        }
    }
    @FXML
    public void goBack(ActionEvent actionEvent){
       loadNewPage(ADMIN_VIEW);
    }
    public void loadNewPage(String path){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
            Stage stage = new Stage();
            fxmlLoader.setController(new AdminViewController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
