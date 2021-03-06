package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.WinesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.WinesListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WinesServiceTest {
    private WinesService winesService;
    private WinesRepository winesRepository;
    private Wines wine;
    private WinesListViewModel winesListViewModel;


    @BeforeEach
    void setUp() {
        this.winesService=WinesService.getInstance();
        this.winesRepository=WinesRepository.getInstance();
        this.wine=new Wines("Wine1",500);
        this.winesListViewModel=new WinesListViewModel("Wine1",79);

    }

    @Test
    void deleteWine() {
        assertFalse(winesService.deleteWine(winesListViewModel));
    }

    @Test
    void getAllWines() {
        ObservableList<WinesListViewModel> all= winesService.getAllWines();
        assertEquals(all,winesService.getAllWines());
    }


    @Test
    void getWineByName() {
        assertEquals(wine,winesService.getWineByName(winesListViewModel.getName_wine()));
    }

    @Test
    void isWineAlreadyCreated() {
        assertTrue(winesService.isWineAlreadyCreated(wine));
    }

    @Test
    void updateWine() {
        assertTrue(winesService.updateWine(winesListViewModel,0));
    }
}