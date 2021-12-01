package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.delete;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.OperatorService;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.OperatorListViewModel;
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

public class DeleteOperatorController implements Initializable {
    OperatorService operatorService=OperatorService.getInstance();
    Stage s;
    @FXML
    private Label label1;
    @FXML
    private Button delete;
    @FXML
    private Button goBack;
    @FXML
    private ComboBox<OperatorListViewModel> operatorComboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillComboBox();
    }
    public DeleteOperatorController(Stage stage){
        this.s=stage;
    }
    private void fillComboBox(){
        ObservableList<OperatorListViewModel> operators=operatorService.getAllOperators();
        operatorComboBox.setItems(operators);
    }
    @FXML
    public void deleteOperator(ActionEvent actionEvent){
        OperatorListViewModel operator=operatorComboBox.getValue();
        operatorService.deleteOperator(operator);
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Successfully deleted operator!", ButtonType.OK);
        alert.show();
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(DELETE_OPERATOR));
            Stage stage = new Stage();
            fxmlLoader.setController(new DeleteOperatorController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void goBack(ActionEvent actionEvent){
        loadNewPage(ADMIN_VIEW);
    }
    private void loadNewPage(String path) {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
            Stage stage = new Stage();
            fxmlLoader.setController(new AdminViewController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
