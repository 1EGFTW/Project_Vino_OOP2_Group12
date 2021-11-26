package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.BottlesService;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.ProductionService;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.WinesService;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Production;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.table.TableRowExpanderColumn;

import javax.persistence.FieldResult;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.ADMIN_VIEW;

public class AddProductionController {
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
    private TextField name_wine;
    @FXML
    private TextField bottle_size;
    @FXML
    private TextField produced_bottles;
    @FXML
    private Button add;
    @FXML
    private Button goBack;
    @FXML
    public void addProduction(ActionEvent actionEvent){
        Wines w= winesService.getWineByName(name_wine.getText());
        Bottles b=bottlesService.getBottleBySize(Integer.parseInt(bottle_size.getText()));
        Production production=new Production(Integer.parseInt(produced_bottles.getText()));
        production.setBottle(b);
        production.setWine(w);
        productionService.addProduction(production);
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
