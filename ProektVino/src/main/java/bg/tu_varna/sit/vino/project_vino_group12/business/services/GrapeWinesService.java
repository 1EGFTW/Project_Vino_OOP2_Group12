package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.GrapeWines;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeRepository;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeWinesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.SortColorRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.GrapeListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.GrapeWinesListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.WinesListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class GrapeWinesService {
    private final GrapeWinesRepository grapeWinesRepository = GrapeWinesRepository.getInstance();
    private final GrapeRepository grapeRepository=GrapeRepository.getInstance();
    private final GrapeService grapeService=GrapeService.getInstance();
    private final WinesService winesService=WinesService.getInstance();
    private final SortColorRepository sortColorRepository=SortColorRepository.getInstance();
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
        GrapeWines temp=new GrapeWines(grapeService.changeListViewToObject(gw.getGrape()), winesService.changeListViewToObject(gw.getWine()), gw.getQuantity_for_wine());
        return temp;
    }
    public void addGrapeWines(GrapeWinesListViewModel g){
        Grape grape=grapeService.getGrapeByName(changeListViewToObject(g).getGrape().getName_sort());
        Wines wine=changeListViewToObject(g).getWine();
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

}
