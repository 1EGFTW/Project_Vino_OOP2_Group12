package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.delete;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.ProductionService;
import bg.tu_varna.sit.vino.project_vino_group12.common.Constants;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.OperatorViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.WarehouseHostViewController;
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

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.*;

public class DeleteProductionController implements Initializable {
    private final ProductionService productionService=ProductionService.getInstance();
    public final int userTracking= Constants.User.UserTracking;
    Stage s;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillComboBox();
    }

    public DeleteProductionController(Stage stage){
        this.s=stage;
    }

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
        userSwitch();
    }

    public void userSwitch(){
        switch (userTracking) {
            case 1 -> loadNewPage(ADMIN_VIEW);
            case 2 -> loadNewPage(OPERATOR_VIEW);
            case 3 -> loadNewPage(WAREHOUSEHOST_VIEW);
        }
    }
    public void loadNewPage(String path){
        if(userTracking==1){
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
        else if(userTracking==2){
            try {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
                Stage stage = new Stage();
                fxmlLoader.setController(new OperatorViewController(stage));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1));
                stage.setResizable(false);
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        else if(userTracking==3){
            try {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
                Stage stage = new Stage();
                fxmlLoader.setController(new WarehouseHostViewController(stage));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1));
                stage.setResizable(false);
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

    }
    @FXML
    public void deleteProduction(ActionEvent actionEvent){
        ProductionListViewModel production=productionComboBox.getValue();
        if(productionService.deleteProduction(production))
        {
            userSwitch();
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Successfully deleted production!", ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add("Alerts.css");
            dialogPane.getStyleClass().add("Alert");
            alert.show();
        }else{
            userSwitch();
            Alert alert=new Alert(Alert.AlertType.ERROR,"Couldn't delete production!", ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add("Alerts.css");
            dialogPane.getStyleClass().add("Alert");
            alert.show();
        }
    }
}
