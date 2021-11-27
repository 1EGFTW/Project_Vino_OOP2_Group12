package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.GrapeWines;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Production;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.BottlesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeRepository;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.ProductionRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.ProductionListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductionService {
    private final ProductionRepository repository = ProductionRepository.getInstance();
    public static ProductionService getInstance() {
        return ProductionServiceHolder.INSTANCE;
    }
    public final BottlesRepository bottlesRepository=BottlesRepository.getInstance();
    public final GrapeRepository grapeRepository=GrapeRepository.getInstance();

    private static class ProductionServiceHolder {
        public static final ProductionService INSTANCE = new ProductionService();
    }

   public ObservableList<ProductionListViewModel> getAllProductions() {
        List<Production> productions = repository.getAll();

        return FXCollections.observableList(
                productions.stream().map(p -> new ProductionListViewModel(
                    p.getWine(),
                    p.getBottle(),
                    p.getProduced_bottles()
        )).collect(Collectors.toList()));
    }
    public void addProduction(Production p)
    {
        int bottle_quantity=p.getBottle().getBottle_quantity();

        bottle_quantity=bottle_quantity-p.getProduced_bottles();

        p.getBottle().setBottle_quantity(bottle_quantity);


        try{
            bottlesRepository.update(p.getBottle());//zapazvane na novoto kolichestvo butilki
            repository.save(p);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
