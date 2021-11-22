package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.create;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.WarehouseHostService;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.WarehouseHost;
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

public class CreateWarehouseHostController {
    private final WarehouseHostService service=WarehouseHostService.getInstance();
    Stage s;
    @FXML
    public Label createHost;
    @FXML
    public PasswordField warehouseHost_pass;
    @FXML
    public TextField warehouseHost_name;
    @FXML
    public Button login;

    public CreateWarehouseHostController(Stage stage) {
        this.s=stage;
    }

    @FXML
    public void onCreateWarehouseHostButtonClick(ActionEvent actionEvent) {
        WarehouseHost w=new WarehouseHost(warehouseHost_name.getText().toString(),warehouseHost_pass.getText().toString());
       service.createWarehouseHost(w);
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
