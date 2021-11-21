package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Production;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.ProductionRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.ProductionListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class ProductionService {
    private final ProductionRepository repository = ProductionRepository.getInstance();
    public static ProductionService getInstance() {
        return ProductionServiceHolder.INSTANCE;
    }

    private static class ProductionServiceHolder {
        public static final ProductionService INSTANCE = new ProductionService();
    }

   /* public ObservableList<ProductionListViewModel> getAllProductions() {
        List<Production> productions = repository.getAll();

        return FXCollections.observableList(
                productions.stream().map(p -> new ProductionListViewModel(
                    p.getWines(),
                    p.getBottles(),
                    p.getProduced_bottles()
        )).collect(Collectors.toList()));
    }

    */
}
