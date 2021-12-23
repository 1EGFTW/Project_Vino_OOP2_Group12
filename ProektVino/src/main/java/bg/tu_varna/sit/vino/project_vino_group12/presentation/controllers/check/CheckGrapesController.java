package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.check;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.GrapeService;
import bg.tu_varna.sit.vino.project_vino_group12.common.Constants;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.OperatorViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.WarehouseHostViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.GrapeListViewModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.*;

public class CheckGrapesController implements Initializable{
    public final int userTracking= Constants.User.UserTracking;
    Stage s;
    @FXML
    private TableView<GrapeListViewModel> grapesTable = new TableView<>();
    @FXML
    private TableColumn<GrapeListViewModel, String> col_Grape = new TableColumn<>();
    @FXML
    private TableColumn<GrapeListViewModel, String> col_Color  = new TableColumn<>();
    @FXML
    private TableColumn<GrapeListViewModel, Integer> col_Quantity  = new TableColumn<>();
    @FXML
    private TableColumn<GrapeListViewModel, Integer> col_Produced  = new TableColumn<>();

    public CheckGrapesController(Stage stage){
        this.s=stage;

    }

    public void displayGrapes(){
        GrapeService grapeService=GrapeService.getInstance();
        ObservableList<GrapeListViewModel> grapeListViewModels=grapeService.getAllGrape();
        col_Grape.setCellValueFactory(new PropertyValueFactory<>("name_sort"));
        col_Color.setCellValueFactory(new PropertyValueFactory<>("sortColor"));
        col_Quantity.setCellValueFactory(new PropertyValueFactory<>("sort_quantity"));
        col_Produced.setCellValueFactory(new PropertyValueFactory<>("quantity_by_kg"));
        grapesTable.setItems(grapeListViewModels);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayGrapes();
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
