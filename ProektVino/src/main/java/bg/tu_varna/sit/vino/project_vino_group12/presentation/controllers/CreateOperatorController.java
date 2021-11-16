package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Operator;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.OperatorRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateOperatorController {

    private final OperatorRepository repository=OperatorRepository.getInstance();
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
        Operator o=new Operator();
        o.setUsername_operator(operator_name.toString());
        o.setPassword_operator(operator_pass.toString());
        try{
            repository.save(o);
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
