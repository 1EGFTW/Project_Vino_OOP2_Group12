package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.WarehouseHost;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.WarehouseHostRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.WarehouseHostListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class WarehouseHostService {
    private final WarehouseHostRepository repository = WarehouseHostRepository.getInstance();
    public static WarehouseHostService getInstance() {
        return WarehouseHostServiceHolder.INSTANCE;
    }

    private static class WarehouseHostServiceHolder {
        public static final WarehouseHostService INSTANCE = new WarehouseHostService();
    }

    public ObservableList<WarehouseHostListViewModel> getAllWarehouseHost() {
        List<WarehouseHost> warehouseHosts = repository.getAll();

        return FXCollections.observableList(
                warehouseHosts.stream().map(wh -> new WarehouseHostListViewModel(
                        wh.getUsername_domakin(),
                        wh.getPassword_domakin()
                )).collect(Collectors.toList()));
    }
}
