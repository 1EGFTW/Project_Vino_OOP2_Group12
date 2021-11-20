package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.WinesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.WinesListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class WinesService {
    private final WinesRepository repository = WinesRepository.getInstance();
    public static  WinesService getInstance() {
        return WinesServiceHolder.INSTANCE;
    }

    private static class WinesServiceHolder {
        public static final WinesService INSTANCE = new WinesService();
    }

  /*  public ObservableList<WinesListViewModel> getAllWines() {
        List<Wines> wines = repository.getAll();

        return FXCollections.observableList(
                wines.stream().map(w -> new WinesListViewModel(
                        w.getName_wine(),
                        w.getId_sort(),
                        w.getTotal()
                )).collect(Collectors.toList()));
    }
   */
}
