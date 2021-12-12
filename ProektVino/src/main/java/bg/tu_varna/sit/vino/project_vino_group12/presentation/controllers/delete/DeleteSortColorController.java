package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.delete;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.SortColorService;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.BottlesListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.SortColorListViewModel;
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

public class DeleteSortColorController implements Initializable {
    SortColorService sortColorService=SortColorService.getInstance();
    Stage s;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillComboBox();
    }
    public DeleteSortColorController(Stage stage){
        this.s=stage;
    }
    @FXML
    private Label label1;
    @FXML
    private Button delete;
    @FXML
    private Button goBack;
    @FXML
    private ComboBox<SortColorListViewModel> colorComboBox;
    private void fillComboBox(){
       ObservableList<SortColorListViewModel> sortColors=sortColorService.getAllSortColor();
       colorComboBox.setItems(sortColors);
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
    public void deleteSortColor(ActionEvent actionEvent){
        SortColorListViewModel color=colorComboBox.getValue();
        sortColorService.deleteColor(color);
        loadNewPage(ADMIN_VIEW);
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Successfully deleted color!", ButtonType.OK);
        alert.show();

    }
}
