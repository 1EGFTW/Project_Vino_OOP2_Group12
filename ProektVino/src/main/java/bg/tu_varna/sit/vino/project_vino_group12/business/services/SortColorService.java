package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.SortColor;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.SortColorRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.SortColorListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class SortColorService {
    private final SortColorRepository repository = SortColorRepository.getInstance();
    public static SortColorService getInstance() {
        return SortColorServiceHolder.INSTANSE;
    }


    private static class SortColorServiceHolder {
        public static final SortColorService INSTANSE = new SortColorService();
    }

    public ObservableList<SortColorListViewModel> getAllSortColor() {
        List<SortColor> sortColors = repository.getAll();

        return FXCollections.observableList(
                sortColors.stream().map(s -> new SortColorListViewModel(
                        s.getColor()
                )).collect(Collectors.toList()));
    }
}