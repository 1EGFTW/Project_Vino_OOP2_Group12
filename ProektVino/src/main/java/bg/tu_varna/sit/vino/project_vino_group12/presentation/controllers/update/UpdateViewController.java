package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.update;

import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.AccessibleAction;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.hibernate.tool.schema.Action;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.*;

public class UpdateViewController {
    Stage s;
    public UpdateViewController(Stage stage){
        this.s=stage;
    }
    @FXML
    public Label label;
    @FXML
    public Button bottle;
    @FXML
    public Button grape;
    @FXML
    public Button wine;
    @FXML
    public Button back;

    @FXML
    public void updateBottles(ActionEvent actionEvent){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(UPDATE_BOTTLES));
            Stage stage = new Stage();
            fxmlLoader.setController(new UpdateBottlesController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void updateGrape(ActionEvent actionEvent){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(UPDATE_GRAPE));
            Stage stage = new Stage();
            fxmlLoader.setController(new UpdateGrapeController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void updateWine(ActionEvent actionEvent){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(UPDATE_WINE));
            Stage stage = new Stage();
            fxmlLoader.setController(new UpdateWineController(stage));
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
            fxmlLoader.setController(new AdminViewController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
