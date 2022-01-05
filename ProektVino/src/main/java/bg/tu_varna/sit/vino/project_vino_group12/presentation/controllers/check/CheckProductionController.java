package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.check;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.ProductionService;
import bg.tu_varna.sit.vino.project_vino_group12.common.Constants;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.OperatorViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.WarehouseHostViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.ProductionListViewModel;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.net.URL;
import java.util.ResourceBundle;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.*;

public class CheckProductionController implements Initializable {
    public final int userTracking= Constants.User.UserTracking;
    public Stage s;
    public CheckProductionController(Stage stage){
        this.s=stage;
    }
    @FXML
    private TableView<ProductionListViewModel> productionTable = new TableView<>();
    @FXML
    private TableColumn<ProductionListViewModel, String> col_Wine = new TableColumn<>();
    @FXML
    private TableColumn<ProductionListViewModel, String> col_Bottle  = new TableColumn<>();
    @FXML
    private TableColumn<ProductionListViewModel, Integer> col_ProducedBottles  = new TableColumn<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayProductions();
    }
    public void displayProductions(){
        ProductionService productionService=ProductionService.getInstance();
        ObservableList<ProductionListViewModel> productionListViewModels=productionService.getAllProductions();
        col_Wine.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ProductionListViewModel, String>, ObservableValue<String>>() {
             @Override
             public ObservableValue<String> call(TableColumn.CellDataFeatures<ProductionListViewModel, String> p) {
                 return new ReadOnlyObjectWrapper(p.getValue().getWines().getName_wine());
             }
     });
        col_Bottle.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ProductionListViewModel, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ProductionListViewModel, String> b) {
                return new ReadOnlyObjectWrapper(b.getValue().getBottles().getBottle_size());
            }
        });
        col_ProducedBottles.setCellValueFactory(new PropertyValueFactory<>("produced_bottles"));
        productionTable.setItems(productionListViewModels);
    }
    @FXML
    public void goBack(ActionEvent actionEvent){
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
}
