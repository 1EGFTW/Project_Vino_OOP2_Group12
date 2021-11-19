package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.OperatorService;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.OperatorListViewModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.ADMIN_VIEW;
import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.OPERATOR_VIEW;

public class OperatorLoginController {
    private final OperatorService service= OperatorService.getInstance();
    Stage s;
    @FXML
    public Label operatorlogin;
    @FXML
    public TextField operator_name;
    @FXML
    public PasswordField operator_pass;
    @FXML
    public Button login;
    public OperatorLoginController(Stage stage){
        s=stage;
    }
    @FXML
    public void onOperatorLoginButtonClick(ActionEvent actionEvent) {
        OperatorListViewModel operatorToLogIn=new OperatorListViewModel(operator_name.getText(),operator_pass.getText());
        if(service.operatorLogin(operatorToLogIn)){
            try {
                s.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(OPERATOR_VIEW));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
