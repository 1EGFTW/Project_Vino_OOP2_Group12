package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.delete;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.WarehouseHostService;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.WarehouseHostListViewModel;
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

public class DeleteWarehouseHostController implements Initializable {
    public Stage s;
    private final WarehouseHostService warehouseHostService=WarehouseHostService.getInstance();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    fillComboBox();
    }

    private void fillComboBox() {
        ObservableList<WarehouseHostListViewModel> hosts=warehouseHostService.getAllWarehouseHost();
        hostComboBox.setItems(hosts);
    }

    public DeleteWarehouseHostController(Stage stage){
        this.s=stage;
    }

    @FXML
    private Button delete;
    @FXML
    private Button goBack;
    @FXML
    private ComboBox<WarehouseHostListViewModel> hostComboBox;

    @FXML
    public void goBack(ActionEvent actionEvent){
        loadNewPage(ADMIN_VIEW);
    }

    @FXML
    public void deleteHost(ActionEvent actionEvent){
        WarehouseHostListViewModel host=hostComboBox.getValue();
        warehouseHostService.deleteHost(host);
        loadNewPage(ADMIN_VIEW);
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Successfully deleted warehouse host!", ButtonType.OK);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add("Alerts.css");
        dialogPane.getStyleClass().add("Alert");
        alert.show();
    }

    private void loadNewPage(String path) {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
            Stage stage = new Stage();
            fxmlLoader.setController(new AdminViewController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
