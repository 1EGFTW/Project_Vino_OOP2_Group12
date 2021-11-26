package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.GrapeWines;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeRepository;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeWinesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.SortColorRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.GrapeListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.GrapeWinesListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class GrapeWinesService {
    private final GrapeWinesRepository grapeWinesRepository = GrapeWinesRepository.getInstance();
    private final GrapeRepository grapeRepository=GrapeRepository.getInstance();
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

    public void addGrapeWines(GrapeWines g){
        int quantity=g.getGrape().getSort_quantity();
        quantity=quantity-g.getQuantity_for_wine();
        g.getGrape().setSort_quantity(quantity);
        try{
            grapeRepository.update(g.getGrape());
            grapeWinesRepository.save(g);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
