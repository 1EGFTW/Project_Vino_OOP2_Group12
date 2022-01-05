package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.GrapeService;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.SortColorService;
import bg.tu_varna.sit.vino.project_vino_group12.common.Constants;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.OperatorViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.WarehouseHostViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.GrapeListViewModel;
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

public class AddGrapeController implements Initializable {
    private final GrapeService grapeService=GrapeService.getInstance();
    public final int userTracking= Constants.User.UserTracking;
    public Stage s;
    @FXML
    public TextField name_sort;
    @FXML
    public ComboBox<SortColorListViewModel> sort_color;
    @FXML
    public TextField quantity_by_kg;
    @FXML
    public TextField sort_quantity;
    @FXML
    public Button createGrape;

    public AddGrapeController(Stage stage) {
        this.s=stage;
    }
    @FXML
    public void createGrape(ActionEvent actionEvent) {
        SortColorListViewModel sc= sort_color.getValue();
        GrapeListViewModel g = new GrapeListViewModel(name_sort.getText(), Integer.parseInt(sort_quantity.getText()), Integer.parseInt(quantity_by_kg.getText()));
        int res=grapeService.addGrape(g,sc);
        if(res==0){
            try {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADD_GRAPE));
                Stage stage = new Stage();
                fxmlLoader.setController(new AddGrapeController(stage));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1));
                stage.setResizable(false);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Alert alert=new Alert(Alert.AlertType.WARNING,"Grape already exists!", ButtonType.CLOSE);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add("Alerts.css");
            dialogPane.getStyleClass().add("Alert");
            alert.show();
        }
        else{
            switch (userTracking) {
                case 1 -> loadNewPage(ADMIN_VIEW);
                case 2 -> loadNewPage(OPERATOR_VIEW);
                case 3 -> loadNewPage(WAREHOUSEHOST_VIEW);
            }
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Grape added", ButtonType.OK);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add("Alerts.css");
            dialogPane.getStyleClass().add("Alert");
            alert.show();
        }
    }
   @FXML
   public void goBack(ActionEvent actionEvent){
       switch (userTracking) {
           case 1 -> loadNewPage(ADMIN_VIEW);
           case 2 -> loadNewPage(OPERATOR_VIEW);
           case 3 -> loadNewPage(WAREHOUSEHOST_VIEW);
       }
   }
    public void fillComboBoxSortColor(){
       ObservableList<SortColorListViewModel> sortColors=SortColorService.getInstance().getAllSortColor();
       sort_color.setItems(sortColors);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillComboBoxSortColor();
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
