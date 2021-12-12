package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.update;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.GrapeService;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.BottlesListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.GrapeListViewModel;
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

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.ADMIN_VIEW;

public class UpdateGrapeController implements Initializable {
    GrapeService grapeService=GrapeService.getInstance();
    Stage s;
    public UpdateGrapeController(Stage stage) {
        this.s = stage;
    }
        @FXML
        public Button update;
        @FXML
        public Button back;
        @FXML
        public ComboBox<GrapeListViewModel> grapes;
        @FXML
        public TextField quantity;
        @FXML
        public Label label;
        @FXML
        public void updateGrape(ActionEvent actionEvent){
           GrapeListViewModel grape=grapes.getValue();
           int newQuantity=Integer.parseInt(quantity.getText());
            if(grapeService.updateGrape(grape,newQuantity)){
                loadNewPage();
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Successfully added!",ButtonType.OK);
                alert.show();
            }
            else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"Error!",ButtonType.OK);
                alert.show();
                quantity.setText("");
            }
        }
        @FXML
        public void goBack(ActionEvent actionEvent){
            loadNewPage();
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            fillComboBox();
        }
        public void fillComboBox(){
            ObservableList<GrapeListViewModel> allGrapes=grapeService.getAllGrape();
            grapes.setItems(allGrapes);
        }
        public void loadNewPage(){
            try {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADMIN_VIEW));
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
