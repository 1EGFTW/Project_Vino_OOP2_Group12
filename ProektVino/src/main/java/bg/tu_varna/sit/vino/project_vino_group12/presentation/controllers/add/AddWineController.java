package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.GrapeService;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.GrapeWinesService;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.WinesService;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.GrapeWines;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.SortColor;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeRepository;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.WinesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.GrapeListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.ADMIN_VIEW;

public class AddWineController {
    private final GrapeService grapeService=GrapeService.getInstance();
    private final  GrapeWinesService grapeWinesService=GrapeWinesService.getInstance();
    private final WinesService winesService=WinesService.getInstance();
    private final WinesRepository winesRepository=WinesRepository.getInstance();
    Stage s;

    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private TextField name_wine;
    @FXML
    private TextField grape;
   /* @FXML
    private ComboBox<Grape> grapeType=new ComboBox<>();*/
    @FXML
    private TextField total;
    @FXML
    private TextField amount;
    @FXML
    private Button create;
    @FXML
    private Button back;

  /*  public void fillComboBoxGrapeType(){
        GrapeRepository grapeRepository=GrapeRepository.getInstance();
        List<Grape> allGrapes =grapeRepository.getAll();
        grapeType.setItems(FXCollections.observableArrayList(allGrapes));
    }*/

    public AddWineController(Stage stage) {
        this.s=stage;
       /* fillComboBoxGrapeType();*/
    }

    @FXML
    public void createWine(ActionEvent actionEvent){
        /*Grape g= (Grape) grapeType.getItems();*/

       Grape g=grapeService.getGrapeByName(grape.getText());
        Wines wine=new Wines(name_wine.getText(),Integer.parseInt(total.getText()));

        wine=winesService.checkWine(wine);
        GrapeWines grapeWines=new GrapeWines();
        grapeWines.setWine(wine);
        grapeWines.setGrape(g);
        grapeWines.setQuantity_for_wine(Integer.parseInt(amount.getText()));
        grapeWinesService.addGrapeWines(grapeWines);

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
}
