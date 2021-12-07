package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrapeWinesListViewModelTest {
    private Grape grape;
    private Wines wine;
    private GrapeWinesListViewModel grapeWinesListViewModel;


    @BeforeEach
    void setUp() {
        grape=new Grape();
        wine=new Wines();
        grapeWinesListViewModel=new GrapeWinesListViewModel(grape,wine,140);
    }

    @Test
    void getGrape() {
        assertEquals(grape,grapeWinesListViewModel.getGrape());
    }

    @Test
    void getWine() {
        assertEquals(wine,grapeWinesListViewModel.getWine());
    }

    @Test
    void getQuantity_for_wine() {
        assertEquals(140,grapeWinesListViewModel.getQuantity_for_wine());
    }
}