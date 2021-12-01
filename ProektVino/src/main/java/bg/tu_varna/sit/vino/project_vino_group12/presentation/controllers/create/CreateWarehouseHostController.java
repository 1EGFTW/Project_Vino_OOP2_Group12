package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.create;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.WarehouseHostService;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.WarehouseHost;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.HelloController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.WarehouseHostListViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.*;

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
        WarehouseHostListViewModel w=new WarehouseHostListViewModel(warehouseHost_name.getText(),warehouseHost_pass.getText());
      int res=service.createWarehouseHost(w);
        if(res==0){
            try {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CREATE_WAREHOUSEHOST));
                Stage stage = new Stage();
                fxmlLoader.setController(new CreateWarehouseHostController(stage));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Alert alert=new Alert(Alert.AlertType.WARNING,"Host already exists!", ButtonType.CLOSE);
            alert.show();
        }
        else{
            loadNewPage(ADMIN_VIEW);
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Host added", ButtonType.OK);
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
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
