package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.delete;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.AdminService;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.BottlesService;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.AdminListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.BottlesListViewModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.*;

public class DeleteBottleController implements Initializable {
    BottlesService bottleService=BottlesService.getInstance();
    Stage s;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillComboBox();
    }
    public DeleteBottleController(Stage stage){
        this.s=stage;
    }
    @FXML
    private Label label1;
    @FXML
    private Button delete;
    @FXML
    private Button goBack;
    @FXML
    private ComboBox<BottlesListViewModel> bottleComboBox;
    private void fillComboBox(){
        ObservableList<BottlesListViewModel>bottles=bottleService.getAllBottles();
        bottleComboBox.setItems(bottles);
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
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void deleteBottle(ActionEvent actionEvent){
        BottlesListViewModel bottle=bottleComboBox.getValue();
        bottleService.deleteBottle(bottle);
        loadNewPage(ADMIN_VIEW);
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Successfully deleted bottle!", ButtonType.OK);
        alert.show();
    }
}
