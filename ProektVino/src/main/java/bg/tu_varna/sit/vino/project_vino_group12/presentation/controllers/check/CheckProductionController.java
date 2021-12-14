package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.check;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.BottlesService;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.GrapeService;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.ProductionService;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.BottlesListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.GrapeListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.ProductionListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.WinesListViewModel;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.ADMIN_VIEW;

public class CheckProductionController implements Initializable {
    Stage s;
    public CheckProductionController(Stage stage){
        this.s=stage;
    }
    @FXML
    private Label label1;
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
