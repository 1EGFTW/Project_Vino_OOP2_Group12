package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.GrapeService;
import bg.tu_varna.sit.vino.project_vino_group12.business.services.SortColorService;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.SortColor;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeRepository;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.SortColorRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.SortColorListViewModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.persistence.criteria.CriteriaBuilder;

public class AddGrapeController {
    private final GrapeRepository grapeRepository= GrapeRepository.getInstance();
    private final SortColorRepository sortColorRepository=SortColorRepository.getInstance();
    private final GrapeService grapeService=GrapeService.getInstance();
    private final SortColorService sortColorService=SortColorService.getInstance();
    Stage s;
    @FXML
    public Label createGrapeLabel;
    @FXML
    public TextField name_sort;
    @FXML
    public TextField id_sort_color;
    @FXML
    public TextField quantity_by_kg;
    @FXML
    public TextField sort_quantity;
    @FXML
    public Label name_sort_label;
    @FXML
    public Label id_sort_color_label;
    @FXML
    public Label sort_quantity_label;
    @FXML
    public Label quantity_by_kg_label;
    @FXML
    public Button createGrape;

    public AddGrapeController(Stage stage) {
        this.s=stage;
    }
   /* @FXML
    public void createGrape(ActionEvent actionEvent) {
        ObservableList<SortColorListViewModel> sortColorListViewModels=sortColorService.getAllSortColor();
        for(SortColorListViewModel sc:sortColorListViewModels)
        {
            if(sc.getColor().equals(id_sort_color.getText()))
            {
                SortColor temp=new SortColor(id_sort_color.getText());
                Grape grape=new Grape(name_sort.getText(),temp, Integer.parseInt(sort_quantity.getText()),Integer.parseInt(quantity_by_kg.getText()));
                try{
                    grapeRepository.save(grape);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    */
}
