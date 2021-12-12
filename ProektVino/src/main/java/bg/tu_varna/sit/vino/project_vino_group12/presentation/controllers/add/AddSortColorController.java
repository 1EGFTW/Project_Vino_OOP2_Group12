package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.SortColorService;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.SortColor;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.SortColorListViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.ADD_SORTCOLOR;
import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.ADMIN_VIEW;

public class AddSortColorController {
    SortColorService service=SortColorService.getInstance();
    Stage s;
    @FXML
    public Label prompt;
    @FXML
    public TextField color;
    @FXML
    public Button addColor;
    public AddSortColorController(Stage s){
        this.s=s;
    }

    @FXML
    public void createSortColor(ActionEvent actionEvent){
      /*  SortColor sortColor=new SortColor();
        sortColor.setColor(color.getText());*/
        SortColorListViewModel sortColor=new SortColorListViewModel(color.getText());
        int res=service.addSortColor(sortColor);
        if(res==0){
            try {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADD_SORTCOLOR));
                Stage stage = new Stage();
                fxmlLoader.setController(new AddSortColorController(stage));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1));
                stage.setResizable(false);
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
            Alert alert=new Alert(Alert.AlertType.WARNING,"Color already exists!", ButtonType.CLOSE);
            alert.show();
        }
        else{
            loadNewPage(ADMIN_VIEW);
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Color added", ButtonType.OK);
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
