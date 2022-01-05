package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.BottlesService;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.ProductionService;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.WinesService;
import bg.tu_varna.sit.vino.project_vino_group12.common.Constants;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.OperatorViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.WarehouseHostViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.BottlesListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.ProductionListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.WinesListViewModel;
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
import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.WAREHOUSEHOST_VIEW;

public class AddProductionController implements Initializable {
    private final WinesService winesService=WinesService.getInstance();
    private final BottlesService bottlesService=BottlesService.getInstance();
    private final ProductionService productionService=ProductionService.getInstance();
    public final int userTracking= Constants.User.UserTracking;
    public Stage s;
    public AddProductionController(Stage stage){
        this.s=stage;
    }
    @FXML
    private ComboBox<WinesListViewModel> name_wine;
    @FXML
    private ComboBox<BottlesListViewModel> bottle_size;
    @FXML
    private TextField produced_bottles;
    @FXML
    private Button add;
    @FXML
    private Button goBack;
    @FXML
    public void addProduction(ActionEvent actionEvent){
        WinesListViewModel w=name_wine.getValue();
        BottlesListViewModel b=bottle_size.getValue();
        ProductionListViewModel production=new ProductionListViewModel(Integer.parseInt(produced_bottles.getText()));
        int res=productionService.addProduction(production,w,b);
        switch (res) {
            case 0 -> {
                try {
                    s.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADD_PRODUCTION));
                    Stage stage = new Stage();
                    fxmlLoader.setController(new AddProductionController(stage));
                    Parent root1 = (Parent) fxmlLoader.load();
                    stage.setScene(new Scene(root1));
                    stage.setResizable(false);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Alert alert1 = new Alert(Alert.AlertType.ERROR, "Not enough bottles available", ButtonType.OK);
                DialogPane dialogPane = alert1.getDialogPane();
                dialogPane.getStylesheets().add("Alerts.css");
                dialogPane.getStyleClass().add("Alert");
                alert1.show();
            }
            case 1 -> {
                userSwitch();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Successful entry!", ButtonType.OK);
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add("Alerts.css");
                dialogPane.getStyleClass().add("Alert");
                alert.show();
            }
            case 2 -> {
                try {
                    s.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADD_PRODUCTION));
                    Stage stage = new Stage();
                    fxmlLoader.setController(new AddProductionController(stage));
                    Parent root1 = (Parent) fxmlLoader.load();
                    stage.setScene(new Scene(root1));
                    stage.setResizable(false);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Alert alert2 = new Alert(Alert.AlertType.ERROR, "Not enough wine available", ButtonType.OK);
                DialogPane dialogPane = alert2.getDialogPane();
                dialogPane.getStylesheets().add("Alerts.css");
                dialogPane.getStyleClass().add("Alert");
                alert2.show();
            }
        }
    }


    public void fillComboBoxes(){
        ObservableList<WinesListViewModel> allWines=winesService.getAllWines();
        ObservableList<BottlesListViewModel> allBottles=bottlesService.getAllBottles();
        name_wine.setItems(allWines);
        bottle_size.setItems(allBottles);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       fillComboBoxes();
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
        }else if(userTracking==2){
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
