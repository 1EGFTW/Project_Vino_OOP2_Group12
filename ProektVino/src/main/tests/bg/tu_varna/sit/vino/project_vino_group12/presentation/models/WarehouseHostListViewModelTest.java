package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseHostListViewModelTest {
    private WarehouseHostListViewModel warehouseHostListViewModel;
    private WarehouseHostListViewModel warehouseHostListViewModel1;
    @BeforeEach
    void setUp() {
        warehouseHostListViewModel=new WarehouseHostListViewModel("host1","host1");
        warehouseHostListViewModel1=new WarehouseHostListViewModel("dasda","host1");
    }

    @Test
    void testEquals() {
        assertFalse(warehouseHostListViewModel.equals(warehouseHostListViewModel1));
    }

    @Test
    void getUsername_domakin() {
        assertEquals("host1",warehouseHostListViewModel.getUsername_domakin());
        assertEquals("dasda",warehouseHostListViewModel1.getUsername_domakin());
    }

    @Test
    void getPassword_domakin() {
        assertEquals("host1",warehouseHostListViewModel.getPassword_domakin());
        assertEquals("host1",warehouseHostListViewModel1.getPassword_domakin());
    }
}