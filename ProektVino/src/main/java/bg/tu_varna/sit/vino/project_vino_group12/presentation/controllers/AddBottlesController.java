package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.BottlesRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AddBottlesController {
    private final BottlesRepository repository=BottlesRepository.getInstance();
    @FXML
    public Label createBottle;
    @FXML
    public TextField bottle_size;
    @FXML
    public TextField bottle_quantity;
    @FXML
    public Button create;

    public void onCreateBottleButtonClick(ActionEvent actionEvent) {
        Bottles bottle=new Bottles(Integer.parseInt(bottle_size.getText()),Integer.parseInt(bottle_quantity.getText()));
        try{
            repository.save(bottle);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
