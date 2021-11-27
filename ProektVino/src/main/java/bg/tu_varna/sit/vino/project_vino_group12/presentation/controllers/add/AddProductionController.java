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
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private ComboBox<Wines> name_wine;
    @FXML
    private ComboBox<Bottles> bottle_size;
    @FXML
    private TextField produced_bottles;
    @FXML
    private Button add;
    @FXML
    private Button goBack;
    @FXML
    public void addProduction(ActionEvent actionEvent){
        Wines w= (Wines) name_wine.getItems();
        Bottles b=(Bottles) bottle_size.getItems();
        Production production=new Production(w,b,Integer.parseInt(produced_bottles.getText()));
        productionService.addProduction(production);
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
        BottlesRepository bottlesRepository=BottlesRepository.getInstance();
        WinesRepository winesRepository=WinesRepository.getInstance();
        List<Bottles> allBottles=bottlesRepository.getAll();
        List<Wines> allWines=winesRepository.getAll();
        name_wine.setItems(FXCollections.observableArrayList(allWines));
        bottle_size.setItems(FXCollections.observableArrayList(allBottles));
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       fillComboBoxes();
    }
}
