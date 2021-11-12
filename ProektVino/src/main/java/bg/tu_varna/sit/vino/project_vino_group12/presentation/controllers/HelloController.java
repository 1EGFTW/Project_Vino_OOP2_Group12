package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.AdminService;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.AdminListViewModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class HelloController {
    private final AdminService service=AdminService.getInstance();
    @FXML
    private Label welcomeText;

    @FXML
    private ListView<AdminListViewModel> listView;

    @FXML
    protected void onHelloButtonClick() {

        welcomeText.setText("Welcome to JavaFX Application!");
        ObservableList<AdminListViewModel> adminListViewModels = service.getAllAdmin();
        listView.setItems(adminListViewModels);
    }
}