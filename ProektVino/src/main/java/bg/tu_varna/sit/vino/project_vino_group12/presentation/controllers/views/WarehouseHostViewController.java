package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views;

import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.HelloController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.HELLO_VIEW;

public class WarehouseHostViewController {
    Stage s;
    @FXML
    public Label successfulLogin;

    public WarehouseHostViewController(Stage stage) {
        this.s=stage;
    }

    @FXML
    public void goBack(ActionEvent actionEvent){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(HELLO_VIEW));
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
