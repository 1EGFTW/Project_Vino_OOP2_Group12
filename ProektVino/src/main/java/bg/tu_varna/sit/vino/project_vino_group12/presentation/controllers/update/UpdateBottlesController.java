package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.update;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.BottlesService;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
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

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.ADMIN_VIEW;

public class UpdateBottlesController implements Initializable {
    BottlesService bottlesService=BottlesService.getInstance();
    Stage s;
    public UpdateBottlesController(Stage stage){
        this.s=stage;
    }
    @FXML
    public Button update;
    @FXML
    public Button back;
    @FXML
    public ComboBox<BottlesListViewModel> bottles;
    @FXML
    public TextField quantity;
    @FXML
    public Label label;
    @FXML
    public void updateBottles(ActionEvent actionEvent){
        BottlesListViewModel bottle=bottles.getValue();
        int newQuantity=Integer.parseInt(quantity.getText());
        if(bottlesService.updateBottleQuantity(bottle,newQuantity)){
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillComboBox();
    }
    public void fillComboBox(){
        ObservableList<BottlesListViewModel> allbottles=bottlesService.getAllBottles();
        bottles.setItems(allbottles);
    }
    public void loadNewPage(){
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
