package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.login;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.WarehouseHostService;
import bg.tu_varna.sit.vino.project_vino_group12.common.Constants;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.HelloController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.WarehouseHostViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.WarehouseHostListViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.*;

public class WarehouseHostLoginController {
    public Stage s;
    private final WarehouseHostService service= WarehouseHostService.getInstance();
    @FXML
    public TextField warehouseHost_name;
    @FXML
    public PasswordField warehouseHost_pass;
    @FXML
    public Button login;

    public WarehouseHostLoginController(Stage stage) {
        s=stage;
    }

    @FXML
    public void onWarehouseHostLoginButtonClick(ActionEvent actionEvent){
        WarehouseHostListViewModel warehouseHostToLogIn=new WarehouseHostListViewModel(warehouseHost_name.getText(),warehouseHost_pass.getText());
      if(service.hostLogin(warehouseHostToLogIn)){
          try {
              Constants.User.LoggedUser=warehouseHost_name.getText();
              s.close();
              FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(WAREHOUSEHOST_VIEW));
              Stage stage = new Stage();
              fxmlLoader.setController(new WarehouseHostViewController(stage));
              Parent root1 = (Parent) fxmlLoader.load();
              stage.setScene(new Scene(root1));
              stage.setResizable(false);
              stage.setWidth(1024);
              stage.setHeight(768);
              stage.show();
          } catch(Exception e) {
              e.printStackTrace();
          }
      }
      else{
          Alert alert=new Alert(Alert.AlertType.INFORMATION,"No such user!",ButtonType.OK);
          DialogPane dialogPane = alert.getDialogPane();
          dialogPane.getStylesheets().add("Alerts.css");
          dialogPane.getStyleClass().add("Alert");
          alert.show();
          warehouseHost_name.setText("");
          warehouseHost_pass.setText("");
      }
    }

    @FXML
    public void goBack(ActionEvent actionEvent){
        loadNewPage(HELLO_VIEW);
    }

    public void loadNewPage(String path){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
            Stage stage = new Stage();
            fxmlLoader.setController(new HelloController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
