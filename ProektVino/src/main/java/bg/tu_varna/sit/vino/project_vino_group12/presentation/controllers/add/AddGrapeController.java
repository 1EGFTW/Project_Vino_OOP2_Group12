package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.GrapeService;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.SortColorService;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Admin;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.SortColor;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeRepository;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.SortColorRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.HelloController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.GrapeListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.SortColorListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import org.hibernate.annotations.Sort;

import javax.persistence.criteria.CriteriaBuilder;

import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.*;

public class AddGrapeController implements Initializable {
    private final GrapeService grapeService=GrapeService.getInstance();
    Stage s;
    @FXML
    public Label createGrapeLabel;
    @FXML
    public TextField name_sort;
    @FXML
    public ComboBox<SortColorListViewModel> sort_color;
    @FXML
    public TextField quantity_by_kg;
    @FXML
    public TextField sort_quantity;
    @FXML
    public Label name_sort_label;
    @FXML
    public Label id_sort_color_label;
    @FXML
    public Label sort_quantity_label;
    @FXML
    public Label quantity_by_kg_label;
    @FXML
    public Button createGrape;

    public AddGrapeController(Stage stage) {
        this.s=stage;
    }
    @FXML
    public void createGrape(ActionEvent actionEvent) {
        SortColorListViewModel sc= (SortColorListViewModel) sort_color.getItems();
       GrapeListViewModel g=new GrapeListViewModel(name_sort.getText(),sc,Integer.parseInt(sort_quantity.getText()),Integer.parseInt(quantity_by_kg.getText()));
        grapeService.addGrape(g);
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
    public void fillComboBoxSortColor(){
       SortColorService sortColorService=SortColorService.getInstance();
        ObservableList<SortColorListViewModel> allSortColors =sortColorService.getAllSortColor();
        sort_color.setItems(allSortColors);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillComboBoxSortColor();
    }
}
