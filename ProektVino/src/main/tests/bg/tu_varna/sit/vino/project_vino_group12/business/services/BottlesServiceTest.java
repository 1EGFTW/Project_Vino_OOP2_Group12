package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.BottlesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.BottlesListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BottlesServiceTest {
    private Bottles bottle;
    private BottlesService bottlesService;
    private BottlesListViewModel bottlesListViewModel;
    private BottlesRepository bottlesRepository;

    @BeforeEach
    void setUp(){
        this.bottle=new Bottles(500,100);
        this.bottlesListViewModel=new BottlesListViewModel(500,100);
        this.bottlesService= BottlesService.getInstance();
        this.bottlesRepository=BottlesRepository.getInstance();
        bottlesRepository.delete(bottle);

    }

    @Test
    void deleteBottle() {
        List<Bottles> allBottles=bottlesRepository.getAll();
        bottlesService.deleteBottle(bottlesListViewModel);
        assertEquals(allBottles, bottlesRepository.getAll());
    }

    @Test
    void getAllBottles() {
        ObservableList<BottlesListViewModel> b=bottlesService.getAllBottles();
        assertEquals(b,bottlesService.getAllBottles());
    }

    @Test
    void addBottle() {
            assertEquals(0,bottlesService.addBottle(bottlesListViewModel));
    }

    @RepeatedTest(5)
    void checkIfBottleExists() {
        assertTrue(bottlesService.checkIfBottleExists(bottle));
    }

    @Test
    void getBottleBySize() {
        assertEquals(bottle,bottlesService.getBottleBySize(bottlesListViewModel.getBottle_size()));
    }

    @RepeatedTest(5)
    void checkCriticalLevels() {
        List<Bottles> res=new LinkedList<>();
        res.add(bottlesService.getBottleBySize(1000));
        assertEquals(res,bottlesService.checkCriticalLevels());
    }

    @Test
    void updateBottleQuantity() {
        assertTrue(bottlesService.updateBottleQuantity(bottlesListViewModel,50));
    }
}