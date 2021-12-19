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
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.OPERATOR_VIEW;
import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.WAREHOUSEHOST_VIEW;

public class WarehouseHostService {
    private final WarehouseHostRepository repository = WarehouseHostRepository.getInstance();
    private static final Logger log=Logger.getLogger(WarehouseHostService.class);
    public static WarehouseHostService getInstance() {
        return WarehouseHostServiceHolder.INSTANCE;
    }
    private static class WarehouseHostServiceHolder {
        public static final WarehouseHostService INSTANCE = new WarehouseHostService();
    }

    public void deleteHost(WarehouseHostListViewModel host) {
        WarehouseHost h=getHostByName(host.getUsername_domakin());
        try{
            repository.delete(h);
            log.info("Host: "+h.getUsername_domakin()+" deleted successfully!");
        }catch(Exception e){
            e.printStackTrace();
            log.error("Error deleting host: "+h.getUsername_domakin()+" - "+e);
        }
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
        if(getHostByName(w.getUsername_domakin())==null){
            log.error("Host login error!");
            return false;
        }
        log.info("Host login successful!");
        return true;
    }
    public int createWarehouseHost(WarehouseHostListViewModel w){
        WarehouseHost host=new WarehouseHost(w.getUsername_domakin(),w.getPassword_domakin());
        if(checkIfHostExists(host)){
            return 0;
        }
        else {
            try {
                repository.save(host);
                log.info("Host:"+host.getUsername_domakin()+" created successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Error creating host: "+host.getUsername_domakin()+" - "+e);
            }
            return 1;
        }
    }
    public WarehouseHost getHostByName(String name){
        List<WarehouseHost> hosts=repository.getAll();
        for(WarehouseHost w:hosts){
            if(w.getUsername_domakin().equals(name)){
                return w;
            }
        }
        log.error("No such host!");
        return null;
    }
    public boolean checkIfHostExists(WarehouseHost w){
        List<WarehouseHost> allHosts=repository.getAll();
        for(WarehouseHost host:allHosts){
            if(host.equals(w)){
                return true;
            }
        }
  /*      log.error("No such host!");*/
        return false;
    }
}
