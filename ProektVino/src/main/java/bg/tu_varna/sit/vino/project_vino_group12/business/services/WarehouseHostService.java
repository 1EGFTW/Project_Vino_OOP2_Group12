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

    public void deleteHost(WarehouseHostListViewModel host) {
        WarehouseHost h=getHostByName(host.getUsername_domakin());
        try{
            repository.delete(h);
        }catch(Exception e){
            e.printStackTrace();
        }
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
    public boolean hostLogin(WarehouseHostListViewModel w){

        ObservableList<WarehouseHostListViewModel> allHosts= getAllWarehouseHost();
        for (WarehouseHostListViewModel host:allHosts)
        {
            if(host.equals(w))
            {
                return true;
            }
        }
       return false;
    }
    public int createWarehouseHost(WarehouseHostListViewModel w){
        WarehouseHost host=new WarehouseHost(w.getUsername_domakin(),w.getPassword_domakin());
        if(checkIfHostExists(host)){
            return 0;
        }
        else {
            try {
                repository.save(host);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 1;
        }
    }
    public WarehouseHost getHostByName(String name){
        List<WarehouseHost> hosts=repository.getAll();
        WarehouseHost temp=new WarehouseHost();
        for(WarehouseHost w:hosts){
            if(w.getUsername_domakin().equals(name)){
                return w;
            }
        }
        return temp;
    }
    public boolean checkIfHostExists(WarehouseHost w){
        List<WarehouseHost> allHosts=repository.getAll();
        for(WarehouseHost host:allHosts){
            if(host.equals(w)){
                return true;
            }
        }
        return false;
    }
}
