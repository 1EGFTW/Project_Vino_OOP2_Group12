package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortColorListViewModelTest {
    private SortColorListViewModel sortColorListViewModel;
    private SortColorListViewModel sortColorListViewModel1;

    @BeforeEach
    void setUp() {
        sortColorListViewModel=new SortColorListViewModel("white");
        sortColorListViewModel1=new SortColorListViewModel("black");
    }

    @Test
    void testEquals() {
        assertFalse(sortColorListViewModel.equals(sortColorListViewModel1));
    }

    @Test
    void getColor() {
        assertEquals("white",sortColorListViewModel.getColor());
        assertEquals("black",sortColorListViewModel1.getColor());
    }
}