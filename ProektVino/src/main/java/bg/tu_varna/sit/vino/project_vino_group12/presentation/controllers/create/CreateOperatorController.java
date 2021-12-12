package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.create;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.OperatorService;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Operator;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.HelloController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views.AdminViewController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.OperatorListViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.*;

public class CreateOperatorController {
    private final OperatorService service=OperatorService.getInstance();
    Stage s;
    @FXML
    public Label createOperator;
    @FXML
    public PasswordField operator_pass;
    @FXML
    public TextField operator_name;
    @FXML
    public Button login;

    public CreateOperatorController(Stage stage) {
        this.s=stage;
    }

    @FXML
    public void onCreateOperatorButtonClick(ActionEvent actionEvent) {
        OperatorListViewModel operator=new OperatorListViewModel(operator_name.getText(),operator_pass.getText());
        int res=service.createOperator(operator);
        if(res==0){
            try {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CREATE_OPERATOR));
                Stage stage = new Stage();
                fxmlLoader.setController(new CreateOperatorController(stage));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1));
                stage.setResizable(false);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Alert alert=new Alert(Alert.AlertType.WARNING,"Operator already exists!", ButtonType.CLOSE);
            alert.show();
        }
        else{
            loadNewPage(ADMIN_VIEW);
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Operator added", ButtonType.OK);
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
