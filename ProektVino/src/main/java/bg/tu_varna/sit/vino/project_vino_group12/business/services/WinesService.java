package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.GrapeWines;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeWinesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.WinesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.WinesListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;
import java.util.List;
import java.util.stream.Collectors;

public class WinesService {
    private final WinesRepository repository = WinesRepository.getInstance();
    private final GrapeWinesRepository grapeWinesRepository = GrapeWinesRepository.getInstance();
    private final ProductionService productionService=ProductionService.getInstance();
    private static final Logger log=Logger.getLogger(WinesService.class);
    public static  WinesService getInstance() {
        return WinesServiceHolder.INSTANCE;
    }
    private static class WinesServiceHolder {
        public static final WinesService INSTANCE = new WinesService();
    }
    public boolean deleteWine(WinesListViewModel wine) {
        GrapeWinesService gwService=GrapeWinesService.getInstance();
        Wines w=getWineByName(wine.getName_wine());
        GrapeWines grapeWines=gwService.getByWineName(w);

        if(productionService.checkIfWineIsInProduction(w)){
            log.error("Wine is in production! Deleting wine: "+w.getName_wine()+" aborted!");
            return false;
        }
        else {
            try {
                grapeWinesRepository.delete(grapeWines);
                repository.delete(w);
                log.info("Wine: "+w.getName_wine()+" deleted successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Error deleting wine: "+w.getName_wine()+" - "+e);
            }
        }
        return true;
    }

   public ObservableList<WinesListViewModel> getAllWines() {
        List<Wines> wines = repository.getAll();

        return FXCollections.observableList(
                wines.stream().map(w -> new WinesListViewModel(
                        w.getName_wine(),
                        w.getTotal()
                )).collect(Collectors.toList()));
    }

    public Wines getWineByName(String name){
        List<Wines> wines=repository.getAll();
        for(Wines w:wines){
            if(w.getName_wine().equals(name)){
                return w;
            }
        }
        log.info("No such wine!");
        return null;
    }

    public boolean isWineAlreadyCreated(Wines w){
        List<Wines> wines=repository.getAll();
        for(Wines wine:wines){
            if(wine.equals(w)){
                log.info("Wine found!");
                return true;
            }
        }
        log.info("No such wine!");
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
            log.info("Wine: "+wine.getName_wine()+" quantity updated successfully!");
            return true;
        }catch(Exception e){
            e.printStackTrace();
            log.error("Error updating wine: "+wine.getName_wine()+" quantity - "+e);
            return false;
        }
    }

}
