package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.SortColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrapeListViewModelTest {

    private GrapeListViewModel grapeListViewModel;
    private GrapeListViewModel grapeListViewModel1;
    private SortColor sortColor;

    @BeforeEach
    void setUp(){
        sortColor=new SortColor("white");
        grapeListViewModel=new GrapeListViewModel("Vladi",sortColor,1000,100);
        grapeListViewModel1=new GrapeListViewModel("Test",sortColor,1000,100);
    }
    @Test
    void testEquals() {
        assertFalse(grapeListViewModel.equals(grapeListViewModel1));
    }

    @Test
    void getName_sort() {
        assertEquals("Vladi",grapeListViewModel.getName_sort());
        assertEquals("Test",grapeListViewModel1.getName_sort());
    }

    @Test
    void getSortColor() {
        assertEquals(sortColor,grapeListViewModel.getSortColor());
        assertEquals(sortColor,grapeListViewModel1.getSortColor());
    }

    @Test
    void getSort_quantity() {
        assertEquals(1000,grapeListViewModel.getSort_quantity());
        assertEquals(1000,grapeListViewModel.getSort_quantity());
    }

    @Test
    void getQuantity_by_kg() {
        assertEquals(100,grapeListViewModel.getQuantity_by_kg());
        assertEquals(100,grapeListViewModel1.getQuantity_by_kg());
    }
}