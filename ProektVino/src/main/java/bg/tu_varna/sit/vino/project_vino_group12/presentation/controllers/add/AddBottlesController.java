package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.BottlesService;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.BottlesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.HelloController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.BottlesListViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.*;

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
        /*Bottles bottle=new Bottles(Integer.parseInt(bottle_size.getText()),Integer.parseInt(bottle_quantity.getText()));*/
        BottlesListViewModel bottle=new BottlesListViewModel(Integer.parseInt(bottle_size.getText()),Integer.parseInt(bottle_quantity.getText()));
        int res=service.addBottle(bottle);
        if(res==0){
            try {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADD_BOTTLES));
                Stage stage = new Stage();
                fxmlLoader.setController(new AddBottlesController(stage));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1));
                stage.setResizable(false);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Alert alert=new Alert(Alert.AlertType.WARNING,"Bottle already exists!", ButtonType.CLOSE);
            alert.show();
        }
        else{
            loadNewPage(ADMIN_VIEW);
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Bottle added", ButtonType.OK);
            alert.show();
        }
    }
    @FXML
    public void goBack(ActionEvent actionEvent){
        loadNewPage(ADMIN_VIEW);
    }
    public void loadNewPage(String path){
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
}
