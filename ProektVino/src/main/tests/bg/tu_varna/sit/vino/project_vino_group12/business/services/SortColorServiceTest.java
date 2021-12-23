package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.SortColor;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.SortColorRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.SortColorListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortColorServiceTest {
    private SortColorService sortColorService;
    private SortColorRepository sortColorRepository;
    private SortColor sortColor;
    private SortColorListViewModel sortColorListViewModel;

    @BeforeEach
    void setUp() {
        this.sortColorRepository=SortColorRepository.getInstance();
        this.sortColorService=SortColorService.getInstance();
        this.sortColor=new SortColor("white");
        this.sortColorListViewModel=new SortColorListViewModel("white");
        sortColorRepository.delete(sortColor);

    }

    @Test
    @Order(5)
    void deleteColor() {
        List<SortColor> all=sortColorRepository.getAll();
        sortColorService.deleteColor(sortColorListViewModel);
        List<SortColor> after=sortColorRepository.getAll();
        assertNotEquals(all,after);
    }

    @Test
    @Order(1)
    void getAllSortColor() {
        ObservableList<SortColorListViewModel> all= sortColorService.getAllSortColor();
        assertEquals(all,sortColorService.getAllSortColor());
    }

    @Test
    @Order(3)
    void checkSortColor() {
        assertTrue(sortColorService.checkSortColor(sortColor));
    }

    @Test
    @Order(4)
    void addSortColor() {
        assertEquals(0,sortColorService.addSortColor(sortColorListViewModel));
    }

    @Test
    @Order(2)
    void getSortColorByName() {
        assertEquals(sortColor.getColor(),sortColorService.getSortColorByName(sortColorListViewModel.getColor()).getColor());
    }
}