package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Admin;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.BottlesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.BottlesListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BottlesService {
    private final BottlesRepository repository = BottlesRepository.getInstance();
    public static BottlesService getInstance(){
        return BottlesRepositoryHolder.INSTANCE;
    }
    private static final Logger log=Logger.getLogger(BottlesService.class);

    public void deleteBottle(BottlesListViewModel bottle) {
        Bottles b=getBottleBySize(bottle.getBottle_size());
        b.setBottle_quantity(0);
        try{
            repository.update(b);
            log.info("Bottle "+b.getBottle_quantity()+" deleted successfully!");
        }catch(Exception e){
            e.printStackTrace();
            log.error("Error deleting bottle "+b);
        }
    }

    private static class BottlesRepositoryHolder {
        public static final BottlesService INSTANCE = new BottlesService();
    }

    public ObservableList<BottlesListViewModel> getAllBottles() {
        List<Bottles> bottles = repository.getAll();

        return FXCollections.observableList(
                bottles.stream().map(b -> new BottlesListViewModel(
                        b.getBottle_size(),
                        b.getBottle_quantity()
                )).collect(Collectors.toList()));
    }
    public int addBottle(BottlesListViewModel b){
        Bottles temp=new Bottles(b.getBottle_size(),b.getBottle_quantity());
        if(checkIfBottleExists(temp)){
            log.info("Bottle "+temp+" already exists!");
            return 0;
        }
        else {
            try {
                repository.save(temp);
                log.info("Bottle "+temp+" added successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Error adding bottle "+temp);
            }
        }
        return 1;
    }
    public boolean checkIfBottleExists(Bottles b){
        List<Bottles> allBottles=repository.getAll();
        for(Bottles bottle:allBottles)
        {
            if(bottle.equals(b))
            {
                log.info("Bottle "+bottle+" already exists!");
                return true;
            }
        }
        log.info("Bottle "+b+" does not exist!");
        return false;
    }
    public Bottles getBottleBySize(int size){
        List<Bottles> bottles=repository.getAll();
        for(Bottles b:bottles)
        {
            if(b.getBottle_size()==size)
            {
                log.info("Bottle "+b+" found!");
                return b;
            }
        }
        return null;
    }
    public List<Bottles> checkCriticalLevels(){
        List<Bottles> allBottles=repository.getAll();
        List<Bottles> temp=new LinkedList<>();
        for(Bottles bottle:allBottles)
        {
            if(bottle.getBottle_quantity()<=2)
            {
                temp.add(bottle);
                log.info("Bottle "+bottle+" at critical level!");
            }
        }
        return temp;
    }
    public boolean updateBottleQuantity(BottlesListViewModel b,int q){
        Bottles bottle=getBottleBySize(b.getBottle_size());
        int temp=0;
        temp=q+bottle.getBottle_quantity();
        bottle.setBottle_quantity(temp);
        try{
            repository.update(bottle);
            log.info("Bottle quantity updated successfully!");
            return true;
        }catch(Exception e){
            e.printStackTrace();
            log.error("Error updating bottle "+bottle+" quantity!");
            return false;
        }
    }
}
