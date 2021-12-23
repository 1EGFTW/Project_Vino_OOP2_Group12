package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductionListViewModelTest {
    private ProductionListViewModel productionListViewModel;
    private Bottles bottles;
    private Wines wine;

    @BeforeEach
    void setUp() {
        bottles=new Bottles();
        wine=new Wines();
        productionListViewModel=new ProductionListViewModel(wine,bottles,14000);
    }

    @Test
    void getWines() {
        assertEquals(wine,productionListViewModel.getWines());
    }

    @Test
    void getBottles() {
        assertEquals(bottles,productionListViewModel.getBottles());
    }

    @Test
    void getProduced_bottles() {
        assertEquals(14000,productionListViewModel.getProduced_bottles());
    }
}