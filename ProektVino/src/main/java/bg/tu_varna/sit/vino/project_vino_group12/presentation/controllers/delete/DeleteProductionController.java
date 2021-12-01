package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.delete;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.ProductionService;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.BottlesListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.ProductionListViewModel;
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
import java.util.concurrent.atomic.LongAdder;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.*;

public class DeleteProductionController implements Initializable {
    ProductionService productionService=ProductionService.getInstance();
    Stage s;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillComboBox();
    }
    public DeleteProductionController(Stage stage){
        this.s=stage;
    }
    @FXML
    private Label label1;
    @FXML
    private Button delete;
    @FXML
    private Button goBack;
    @FXML
    private ComboBox<ProductionListViewModel> productionComboBox;
    private void fillComboBox(){
      ObservableList<ProductionListViewModel> productions=productionService.getAllProductions();
      productionComboBox.setItems(productions);
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
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void deleteProduction(ActionEvent actionEvent){
        ProductionListViewModel production=productionComboBox.getValue();
        productionService.deleteProduction(production);
        loadNewPage(ADMIN_VIEW);
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Successfully deleted production!", ButtonType.OK);
        alert.show();
    }
}
