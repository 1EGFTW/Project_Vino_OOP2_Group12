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
    private final GrapeWinesService grapeWinesService=GrapeWinesService.getInstance();
    private final ProductionService productionService=ProductionService.getInstance();
    public static  WinesService getInstance() {
        return WinesServiceHolder.INSTANCE;
    }

    public boolean deleteWine(WinesListViewModel wine) {
        GrapeWinesService gwService=GrapeWinesService.getInstance();
        Wines w=getWineByName(wine.getName_wine());
        GrapeWines grapeWines=gwService.getByWineName(w);
        if(productionService.checkIfWineIsInProduction(w)){
            return false;
        }
        else {
            //variant e ako iskame da se trie vinoto no porudction da ostava, varianta e da se set-va total=0
            try {
                grapeWinesRepository.delete(grapeWines);
                repository.delete(w);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
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
        for(Wines w:wines){
            if(w.getName_wine().equals(name)){
                return w;
            }
        }
        return null;
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

    public boolean updateWine(WinesListViewModel w,int q){
        Wines wine=getWineByName(w.getName_wine());
        if(wine==null){
            return false;
        }
        int temp=q+wine.getTotal();
        wine.setTotal(temp);
        try{
            repository.update(wine);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
