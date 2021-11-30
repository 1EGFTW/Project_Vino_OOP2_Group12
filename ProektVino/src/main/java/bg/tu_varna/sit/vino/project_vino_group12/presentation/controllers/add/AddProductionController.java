package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.BottlesService;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.ProductionService;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.WinesService;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Production;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.BottlesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.WinesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.BottlesListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.ProductionListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.WinesListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.controlsfx.control.table.TableRowExpanderColumn;

import javax.persistence.FieldResult;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.ADMIN_VIEW;

public class AddProductionController implements Initializable {
    private final WinesService winesService=WinesService.getInstance();
    private final BottlesService bottlesService=BottlesService.getInstance();
    private final ProductionService productionService=ProductionService.getInstance();
    Stage s;
    public AddProductionController(Stage stage){
        this.s=stage;
    }
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
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
       /* Wines w= name_wine.getValue();
        Bottles b= bottle_size.getValue();
        Production production=new Production(w,b,Integer.parseInt(produced_bottles.getText()));*/
        WinesListViewModel w=name_wine.getValue();
        BottlesListViewModel b=bottle_size.getValue();
        Wines wine=winesService.changeListViewToObject(w);
        Bottles bottles=bottlesService.convertListViewToObject(b);
        ProductionListViewModel production=new ProductionListViewModel(wine,bottles,Integer.parseInt(produced_bottles.getText()));
        if(productionService.addProduction(production)==1) {
            try {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADMIN_VIEW));
                Stage stage = new Stage();
                fxmlLoader.setController(new AdminViewController(stage));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(productionService.addProduction(production)==2){
            Alert alert=new Alert(Alert.AlertType.ERROR,"Not enough bottles available",ButtonType.OK);
            alert.show();
        }
        else{
            Alert alert=new Alert(Alert.AlertType.ERROR,"Not enough wine available",ButtonType.OK);
            alert.show();
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
}
