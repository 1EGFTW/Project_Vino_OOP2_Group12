package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.GrapeWines;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeWinesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.WinesRepository;
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

    private static class WinesServiceHolder {
        public static final WinesService INSTANCE = new WinesService();
    }

   public ObservableList<WinesListViewModel> getAllWines() {
        List<Wines> wines = repository.getAll();

        return FXCollections.observableList(
                wines.stream().map(w -> new WinesListViewModel(
                        w.getName_wine(),
                        w.getGrapeWines(),
                        w.getTotal()
                )).collect(Collectors.toList()));
    }
    public Wines checkWine(Wines w){
        List<Wines> wines=repository.getAll();
        for(Wines wine:wines){
            if(wine.equals(w)){
                return wine;
            }else{
                try{
                    repository.save(w);
                }catch (Exception e){
                    e.printStackTrace();
                }
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
            }
        }
        return temp;
    }


}
