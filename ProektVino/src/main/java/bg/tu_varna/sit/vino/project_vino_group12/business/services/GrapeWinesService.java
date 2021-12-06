package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.GrapeWines;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeRepository;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeWinesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.ProductionRepository;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.SortColorRepository;
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
    private static final org.apache.log4j.Logger log = Logger.getLogger(GrapeService.class);
    private final GrapeRepository grapeRepository=GrapeRepository.getInstance();
    private final GrapeService grapeService=GrapeService.getInstance();
    private final WinesService winesService=WinesService.getInstance();
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
                        grapeService.convertGrapeToListView(g.getGrape()),
                        winesService.convertWinesToListView(g.getWine()),
                        g.getQuantity_for_wine()
                )).collect(Collectors.toList()));
    }
    public GrapeWines changeListViewToObject(GrapeWinesListViewModel gw){
       return new GrapeWines(grapeService.convertListViewToObject(gw.getGrape()), winesService.changeListViewToObject(gw.getWine()), gw.getQuantity_for_wine());

    }
    public void addGrapeWines(GrapeWinesListViewModel g,GrapeListViewModel gr,WinesListViewModel w){
        /*Grape grape=grapeService.getGrapeByName(changeListViewToObject(g).getGrape().getName_sort());*/
        Grape grape = new Grape(gr.getName_sort());
        try {
            if (grapeService.checkIfGrapeExists(grape)) {
                grape = grapeService.getGrapeByName(grape.getName_sort());
            }
        }catch(Exception e){
            e.printStackTrace();
            log.error("Error: " +e);
        }

        /*Wines wine=changeListViewToObject(g).getWine();*/
        Wines wine=new Wines(w.getName_wine(),w.getTotal());
        if(winesService.isWineAlreadyCreated(wine)){
            wine=winesService.getWineByName(wine.getName_wine());
        }
        GrapeWines grapeWines=new GrapeWines(grape,wine,changeListViewToObject(g).getQuantity_for_wine());

        int quantity=grapeWines.getGrape().getSort_quantity();
        quantity=quantity-grapeWines.getQuantity_for_wine();
        grapeWines.getGrape().setSort_quantity(quantity);

        try{
            grapeRepository.update(grape);
            grapeWinesRepository.save(grapeWines);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public GrapeWines getByGrapeName(Grape g){
        List<GrapeWines> grapeWines=grapeWinesRepository.getAll();
        GrapeWines temp=new GrapeWines();
        for(GrapeWines gr:grapeWines){
            if(gr.getGrape().equals(g)){
                return gr;
            }
        }
        return temp;
    }

}
