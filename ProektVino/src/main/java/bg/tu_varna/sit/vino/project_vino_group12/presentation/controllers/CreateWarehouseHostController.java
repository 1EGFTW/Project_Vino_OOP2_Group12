package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.WarehouseHostService;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.WarehouseHost;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.WarehouseHostRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateWarehouseHostController {
    private final WarehouseHostService service=WarehouseHostService.getInstance();
    @FXML
    public Label createHost;
    @FXML
    public PasswordField warehouseHost_pass;
    @FXML
    public TextField warehouseHost_name;
    @FXML
    public Button login;

    @FXML
    public void onCreateWarehouseHostButtonClick(ActionEvent actionEvent) {
        WarehouseHost w=new WarehouseHost(warehouseHost_name.getText().toString(),warehouseHost_pass.getText().toString());
       service.createWarehouseHost(w);
    }
}
