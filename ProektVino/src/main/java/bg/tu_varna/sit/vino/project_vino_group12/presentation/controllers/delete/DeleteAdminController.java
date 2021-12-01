package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.delete;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.AdminService;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.HelloController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.AdminListViewModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleAction;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.*;

public class DeleteAdminController implements Initializable {
    AdminService adminService=AdminService.getInstance();
    Stage s;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillComboBox();
    }
    public DeleteAdminController(Stage stage){
        this.s=stage;
    }
    @FXML
    private Label label1;
    @FXML
    private Button delete;
    @FXML
    private Button goBack;
    @FXML
    private ComboBox<AdminListViewModel> adminComboBox;
    @FXML
    private void deleteAdmin(ActionEvent actionEvent){
        AdminListViewModel admin=adminComboBox.getValue();
        adminService.deleteAdmin(admin);
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Successfully deleted admin!", ButtonType.OK);
            alert.show();
            try {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(DELETE_ADMIN));
                Stage stage = new Stage();
                fxmlLoader.setController(new DeleteAdminController(stage));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    private void fillComboBox(){
        ObservableList<AdminListViewModel> admins=adminService.getAllAdmin();
        adminComboBox.setItems(admins);
    }
    @FXML
    public void goBack(ActionEvent actionEvent){
        loadNewPage(ADMIN_VIEW);
    }
    private void loadNewPage(String path){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
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
