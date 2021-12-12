package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Production;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.ProductionRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.BottlesListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.ProductionListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.WinesListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductionServiceTest {
    private Wines wine;
    private Production production;
    private Bottles bottle;
    private WinesListViewModel winesListViewModel;
    private BottlesListViewModel bottlesListViewModel;
    private ProductionListViewModel productionListViewModel;
    private ProductionService productionService;
    private ProductionRepository productionRepository;
    @BeforeEach
    void setUp() {
        this.productionService=ProductionService.getInstance();
        this.productionRepository=ProductionRepository.getInstance();
        this.wine=new Wines("gfsfsdf",100);
        this.bottle=new Bottles(999,100);
        this.production=new Production(wine,bottle,1);
        this.winesListViewModel=new WinesListViewModel("gfsfsdf",100);
        this.bottlesListViewModel=new BottlesListViewModel(999,100);
        this.productionListViewModel=new ProductionListViewModel(wine,bottle,1);
    }

    @Test
    void deleteProduction() {
        List<Production> all=productionRepository.getAll();
        productionService.deleteProduction(productionListViewModel);
        List<Production> after=productionRepository.getAll();
        assertEquals(all,after);
    }

    @Test
    void getAllProductions() {
        ObservableList<ProductionListViewModel> all= productionService.getAllProductions();
        assertEquals(all,productionService.getAllProductions());
    }

    @Test
    void getProduction() {
        assertNull(productionService.getProduction(productionListViewModel));
    }

    @Test
    void checkIfWineIsInProduction() {
        assertFalse(productionService.checkIfWineIsInProduction(wine));
    }

    @Test
    void addProduction() {
        assertEquals(0,productionService.addProduction(productionListViewModel,winesListViewModel,bottlesListViewModel));
    }
}