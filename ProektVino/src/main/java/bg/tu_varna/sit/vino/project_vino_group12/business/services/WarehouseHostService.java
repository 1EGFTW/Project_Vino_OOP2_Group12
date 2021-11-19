package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Admin;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.WarehouseHost;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.WarehouseHostRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.OperatorListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.WarehouseHostListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.OPERATOR_VIEW;
import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.WAREHOUSEHOST_VIEW;

public class WarehouseHostService {
    public boolean logIn=false;
    private final WarehouseHostRepository repository = WarehouseHostRepository.getInstance();
    public static WarehouseHostService getInstance() {
        return WarehouseHostServiceHolder.INSTANCE;
    }

    private static class WarehouseHostServiceHolder {
        public static final WarehouseHostService INSTANCE = new WarehouseHostService();
    }

    public ObservableList<WarehouseHostListViewModel> getAllWarehouseHost() {
        List<WarehouseHost> warehouseHosts = repository.getAll();

        return FXCollections.observableList(
                warehouseHosts.stream().map(wh -> new WarehouseHostListViewModel(
                        wh.getUsername_domakin(),
                        wh.getPassword_domakin()
                )).collect(Collectors.toList()));
    }
    public void hostLogin(WarehouseHostListViewModel w){

        ObservableList<WarehouseHostListViewModel> allHosts= getAllWarehouseHost();
        for (WarehouseHostListViewModel host:allHosts)
        {
            if(host.equals(w))
            {
                logIn=true;
            }
        }
        if(logIn)
        {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(WAREHOUSEHOST_VIEW));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void createWarehouseHost(WarehouseHost w){
            try{
                repository.save(w);
            }
            catch (Exception e) {
                e.printStackTrace();
            }

    }
}
