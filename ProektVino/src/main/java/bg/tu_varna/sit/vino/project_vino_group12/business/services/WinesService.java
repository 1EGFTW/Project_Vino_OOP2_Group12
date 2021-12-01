package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.GrapeWines;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.SortColor;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeWinesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.WinesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.GrapeListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.SortColorListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.WinesListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class WinesService {
    private final WinesRepository repository = WinesRepository.getInstance();
    private final GrapeWinesRepository grapeWinesRepository = GrapeWinesRepository.getInstance();
    public static  WinesService getInstance() {
        return WinesServiceHolder.INSTANCE;
    }

    public void deleteWine(WinesListViewModel wine) {
        Wines w=getWineByName(wine.getName_wine());
        try{
            repository.delete(w);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static class WinesServiceHolder {
        public static final WinesService INSTANCE = new WinesService();
    }

   public ObservableList<WinesListViewModel> getAllWines() {
        List<Wines> wines = repository.getAll();

        return FXCollections.observableList(
                wines.stream().map(w -> new WinesListViewModel(
                        w.getName_wine(),
                        w.getTotal()
                )).collect(Collectors.toList()));
    }
    public WinesListViewModel checkWine(WinesListViewModel w){
        ObservableList<WinesListViewModel> wines=getAllWines();
        for(WinesListViewModel wine:wines){
            if(wine.equals(w)){
                return w;
            }
        }
        return w;
    }
    public Wines getWineByName(String name){
        List<Wines> wines=repository.getAll();
        Wines temp=new Wines();
        for(Wines w:wines){
            if(w.getName_wine().equals(name)){
                temp=w;
                return temp;
            }
        }
        return temp;
    }
    public boolean isWineAlreadyCreated(Wines w){
        List<Wines> wines=repository.getAll();
        for(Wines wine:wines){
            if(wine.equals(w)){
                return true;
            }
        }
        return false;
    }
    public WinesListViewModel convertWinesToListView(Wines w){
        WinesListViewModel winesListViewModel=new WinesListViewModel(w.getName_wine(),w.getTotal());
        return winesListViewModel;
    }
    public Wines changeListViewToObject(WinesListViewModel w){
        Wines temp=new Wines(w.getName_wine(),w.getTotal());
        return temp;
    }


}
