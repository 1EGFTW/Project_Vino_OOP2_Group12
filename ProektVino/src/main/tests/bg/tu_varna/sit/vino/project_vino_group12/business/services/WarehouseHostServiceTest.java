package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.WarehouseHost;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.WarehouseHostRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.WarehouseHostListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseHostServiceTest {
    private WarehouseHostService warehouseHostService;
    private WarehouseHostRepository warehouseHostRepository;
    private WarehouseHost warehouseHost;
    private WarehouseHostListViewModel warehouseHostListViewModel;

    @BeforeEach
    void setUp() {
        this.warehouseHostService=WarehouseHostService.getInstance();
        this.warehouseHostRepository=WarehouseHostRepository.getInstance();
        this.warehouseHost=new WarehouseHost("1","1");
        this.warehouseHostListViewModel=new WarehouseHostListViewModel("1","1");
    }

    @Test
    void deleteHost() {
        List<WarehouseHost> all=warehouseHostRepository.getAll();
        warehouseHostService.deleteHost(warehouseHostListViewModel);
        List<WarehouseHost> after=warehouseHostRepository.getAll();
        assertNotEquals(all,after);

    }

    @Test
    void getAllWarehouseHost() {
        ObservableList<WarehouseHostListViewModel> all= warehouseHostService.getAllWarehouseHost();
        assertEquals(all,warehouseHostService.getAllWarehouseHost());
    }

    @Test
    void hostLogin() {
        assertFalse(warehouseHostService.hostLogin(warehouseHostListViewModel));
    }

    @Test
    void createWarehouseHost() {
        assertEquals(1,warehouseHostService.createWarehouseHost(warehouseHostListViewModel));
    }

    @Test
    void getHostByName() {
        assertNull(/*warehouseHost,*/warehouseHostService.getHostByName(warehouseHostListViewModel.getUsername_domakin()));
    }

    @Test
    void checkIfHostExists() {
        assertFalse(warehouseHostService.checkIfHostExists(warehouseHost));
    }
}