package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinesListViewModelTest {
    private WinesListViewModel winesListViewModel;

    @BeforeEach
    void setUp() {
        winesListViewModel=new WinesListViewModel("WINE1",41144);
    }

    @Test
    void getName_wine() {
        assertEquals("WINE1",winesListViewModel.getName_wine());
    }

    @Test
    void getTotal() {
        assertEquals(41144,winesListViewModel.getTotal());
    }
}