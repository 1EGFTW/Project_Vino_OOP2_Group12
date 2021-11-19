package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.OperatorService;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Operator;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.OperatorRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.OperatorListViewModel;
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

public class CreateOperatorController {
    private final OperatorService service=OperatorService.getInstance();
    @FXML
    public Label createOperator;
    @FXML
    public PasswordField operator_pass;
    @FXML
    public TextField operator_name;
    @FXML
    public Button login;

    @FXML
    public void onCreateOperatorButtonClick(ActionEvent actionEvent) {
        Operator operator=new Operator(operator_name.getText().toString(),operator_pass.getText().toString());
        service.createOperator(operator);

    }
}
