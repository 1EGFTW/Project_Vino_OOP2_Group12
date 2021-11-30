package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Admin;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.BottlesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.BottlesListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BottlesService {
    private final BottlesRepository repository = BottlesRepository.getInstance();
    public static BottlesService getInstance(){
        return BottlesRepositoryHolder.INSTANCE;
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
            return 0;
        }
        else {
            try {
                repository.save(temp);
            } catch (Exception e) {
                e.printStackTrace();
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
                return true;
            }
        }
        return false;
    }
    public Bottles getBottleBySize(int size){
        List<Bottles> bottles=repository.getAll();
        Bottles temp=new Bottles();
        for(Bottles b:bottles)
        {
            if(b.getBottle_size()==size)
            {
                temp=b;
            }
        }
        return temp;
    }
    public Bottles convertListViewToObject(BottlesListViewModel b){
        return new Bottles(b.getBottle_size(),b.getBottle_quantity());
    }
    public List<Bottles> checkCriticalLevels(){
        List<Bottles> allBottles=repository.getAll();
        List<Bottles> temp=new LinkedList<>();
        for(Bottles bottle:allBottles)
        {
            if(bottle.getBottle_quantity()<=100)
            {
                temp.add(bottle);
            }
        }
        return temp;
    }
}
