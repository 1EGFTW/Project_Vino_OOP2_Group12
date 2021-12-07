package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BottlesListViewModelTest {
    private BottlesListViewModel bottle1;
    private BottlesListViewModel bottle2;
    @BeforeEach
    void setUp(){
        bottle1=new BottlesListViewModel(100,10);
        bottle2=new BottlesListViewModel(50,9);
    }

    @Test
    void getBottle_size() {
        assertEquals(100,bottle1.getBottle_size());
        assertEquals(50,bottle2.getBottle_size());
    }

    @Test
    void getBottle_quantity() {
        assertEquals(10,bottle1.getBottle_quantity());
        assertEquals(9,bottle2.getBottle_quantity());
    }
}