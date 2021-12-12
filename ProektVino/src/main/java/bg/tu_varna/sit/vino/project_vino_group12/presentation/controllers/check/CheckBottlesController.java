package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.check;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.BottlesService;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.ADMIN_VIEW;

public class CheckBottlesController implements Initializable {
    Stage s;
    public CheckBottlesController(Stage stage){
        this.s=stage;
    }
    @FXML
    private Label label1;
    @FXML
    private TableView<BottlesListViewModel> bottlesTable = new TableView<>();
    @FXML
    private TableColumn<BottlesListViewModel, Integer> bottleSize = new TableColumn<>();
    @FXML
    private TableColumn<BottlesListViewModel, Integer> bottleQuantity  = new TableColumn<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayBottles();
    }
    public void displayBottles(){
        BottlesService bottlesService=BottlesService.getInstance();
        ObservableList<BottlesListViewModel> bottlesListViewModels=bottlesService.getAllBottles();
            bottleSize.setCellValueFactory(new PropertyValueFactory<>("bottle_size"));
            bottleQuantity.setCellValueFactory(new PropertyValueFactory<>("bottle_quantity"));
            bottlesTable.setItems(bottlesListViewModels);
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
