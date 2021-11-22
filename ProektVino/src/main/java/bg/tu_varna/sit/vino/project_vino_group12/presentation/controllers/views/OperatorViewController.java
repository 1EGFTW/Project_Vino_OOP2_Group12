package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class OperatorViewController {
    Stage s;
    @FXML
    private Label successfulLogin;

    public OperatorViewController(Stage stage) {
        this.s=stage;
    }
}
