package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.AdminService;
import bg.tu_varna.sit.vino.project_vino_group12.common.Constants;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.AdminListViewModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloController {
    private final AdminService service=AdminService.getInstance();
    @FXML
    private Label HelloText;

    @FXML
    private Button adminButton;

    @FXML
    private ListView<AdminListViewModel> listView;

    @FXML
    protected void onHelloButtonClick() {
       // ObservableList<AdminListViewModel> adminListViewModels = service.getAllAdmin();
        //listView.setItems(adminListViewModels);

    }


}