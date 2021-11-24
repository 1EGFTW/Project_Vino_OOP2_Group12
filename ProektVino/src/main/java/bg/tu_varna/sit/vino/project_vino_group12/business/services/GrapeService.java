package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.SortColor;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeRepository;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.SortColorRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.GrapeListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.SortColorListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class GrapeService {
    private final GrapeRepository grapeRepository = GrapeRepository.getInstance();
    private final SortColorRepository sortColorRepository=SortColorRepository.getInstance();
    public static GrapeService getInstance() {
        return GrapeServiceHolder.INSTANCE;
    }

    private static class GrapeServiceHolder {
        public static final GrapeService INSTANCE = new GrapeService();
    }

    public ObservableList<GrapeListViewModel> getAllGrape() {
        List<Grape> grapes = grapeRepository.getAll();

        return FXCollections.observableList(
                grapes.stream().map(g -> new GrapeListViewModel(
                        g.getName_sort(),
                        g.getSortColor(),
                        g.getSort_quantity(),
                        g.getQuantity_by_kg()
                )).collect(Collectors.toList()));
    }

    public void addGrape(Grape g){
        List<SortColor> sortColors=sortColorRepository.getAll();
        g.getSortColor().addGrape(g);
            for (SortColor sortColor : sortColors) {
                if (g.getSortColor().equals(sortColor)) {
                    g.setSortColor(sortColor);
                    break;
                }
            }
            try{
                grapeRepository.save(g);
            }catch (Exception e){
                e.printStackTrace();
            }
    }
    public Grape getGrapeByName(String name){
        List<Grape> grapes=grapeRepository.getAll();
        Grape temp=new Grape();
        for(Grape g:grapes){
            if(g.getName_sort().equals(name)){
                temp=g;
            }
        }
        return temp;
    }
}
