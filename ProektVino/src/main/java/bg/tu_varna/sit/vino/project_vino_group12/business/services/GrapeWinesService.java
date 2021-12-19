package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.GrapeWines;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.*;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.GrapeListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.GrapeWinesListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.WinesListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class GrapeWinesService {
    private final GrapeWinesRepository grapeWinesRepository = GrapeWinesRepository.getInstance();
    private static final org.apache.log4j.Logger log = Logger.getLogger(GrapeWinesService.class);
    private final GrapeRepository grapeRepository=GrapeRepository.getInstance();
    private final WinesRepository winesRepository=WinesRepository.getInstance();
    public static GrapeWinesService getInstance() {
        return GrapeWinesService.GrapeWinesServiceHolder.INSTANCE;
    }


    private static class GrapeWinesServiceHolder {
        public static final GrapeWinesService INSTANCE = new GrapeWinesService();
    }
    public ObservableList<GrapeWinesListViewModel> getAllGrapeWines() {
        List<GrapeWines> grapes = grapeWinesRepository.getAll();
        return FXCollections.observableList(
                grapes.stream().map(g -> new GrapeWinesListViewModel(
                        g.getGrape(),
                        g.getWine(),
                        g.getQuantity_for_wine()
                )).collect(Collectors.toList()));
    }

    public void addGrapeWines(GrapeWinesListViewModel g, GrapeListViewModel gr, WinesListViewModel w){
        /*Grape grape=grapeService.getGrapeByName(changeListViewToObject(g).getGrape().getName_sort());*/
        GrapeService service=GrapeService.getInstance();
        WinesService wService=WinesService.getInstance();
        Grape grape = service.getGrapeByName(gr.getName_sort());
        /*Wines wine=changeListViewToObject(g).getWine();*/
/*        Wines wine=new Wines(w.getName_wine(),w.getTotal());*/ // raboteshto
        Wines wine=new Wines(w.getName_wine());
        int total=0;
        if(wService.isWineAlreadyCreated(wine)){
            wine=wService.getWineByName(wine.getName_wine());
            total=wine.getTotal();
        }
        total=total+((grape.getQuantity_by_kg()*g.getQuantity_for_wine())/1000);
        wine.setTotal(total);
        GrapeWines grapeWines=new GrapeWines(grape,wine,g.getQuantity_for_wine());

        int quantity=grapeWines.getGrape().getSort_quantity();
        quantity=quantity-grapeWines.getQuantity_for_wine();
        grapeWines.getGrape().setSort_quantity(quantity);

        try{
            grapeRepository.update(grape);
            log.info("Grape:"+grape.getName_sort()+" quantity updated successfully!");
            grapeWinesRepository.save(grapeWines);
            log.info("wine "+grapeWines.getWine().getName_wine()+" created successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("Error creating wine "+grapeWines.getWine().getName_wine()+" :"+e);
        }
    }
    public GrapeWines getByGrapeName(Grape g){
        List<GrapeWines> grapeWines=grapeWinesRepository.getAll();
        for(GrapeWines gr:grapeWines){
            if(gr.getGrape().equals(g)){
                return gr;
            }
        }
        log.error("No such grape/wine!");
        return null;
    }
    public GrapeWines getByWineName(Wines w){
        List<GrapeWines> grapeWines=grapeWinesRepository.getAll();
        for(GrapeWines gr:grapeWines){
            if(gr.getWine().equals(w)){
                return gr;
            }
        }
        log.error("No such wine!");
        return null;
    }

}
