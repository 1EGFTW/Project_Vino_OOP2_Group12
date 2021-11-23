package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Admin;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.BottlesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.BottlesListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class BottlesService {
    private final BottlesRepository repository = BottlesRepository.getInstance();
    public static BottlesService getInstance(){
        return BottlesRepositoryHolder.INSTANCE;
    }

    private static class BottlesRepositoryHolder {
        public static final BottlesService INSTANCE = new BottlesService();
    }

    public ObservableList<BottlesListViewModel> getAllBottles() {
        List<Bottles> bottles = repository.getAll();

        return FXCollections.observableList(
                bottles.stream().map(b -> new BottlesListViewModel(
                        b.getBottle_size(),
                        b.getBottle_quantity()
                )).collect(Collectors.toList()));
    }
    public void addBottle(Bottles b){
        try{
            repository.save(b);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
