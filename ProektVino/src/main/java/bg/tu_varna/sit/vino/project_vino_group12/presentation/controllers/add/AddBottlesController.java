package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.BottlesService;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.BottlesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.HelloController;
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

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.ADMIN_VIEW;
import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.HELLO_VIEW;

public class AddBottlesController {
    private final BottlesService service=BottlesService.getInstance();
    Stage s;
    @FXML
    public Label createBottle;
    @FXML
    public TextField bottle_size;
    @FXML
    public TextField bottle_quantity;
    @FXML
    public Button create;

    public AddBottlesController(Stage s) {
        this.s = s;
    }

    public void onCreateBottleButtonClick(ActionEvent actionEvent) {
        Bottles bottle=new Bottles(Integer.parseInt(bottle_size.getText()),Integer.parseInt(bottle_quantity.getText()));
        service.addBottle(bottle);
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
}