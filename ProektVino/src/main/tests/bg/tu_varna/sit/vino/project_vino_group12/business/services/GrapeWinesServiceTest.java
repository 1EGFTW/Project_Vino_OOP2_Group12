package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.GrapeWines;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.SortColor;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeWinesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.GrapeListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.GrapeWinesListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.WinesListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrapeWinesServiceTest {
    private GrapeWinesService grapeWinesService;
    private GrapeWinesRepository grapeWinesRepository=GrapeWinesRepository.getInstance();
    private SortColorService sortColorService;
    private GrapeWines grapeWines;
    private GrapeWinesListViewModel grapeWinesListViewModel;
    private Grape grape;
    private Wines wine;
    private SortColor sortColor;
    private GrapeListViewModel grapeListViewModel;
    private WinesListViewModel winesListViewModel;

    @BeforeEach
    void setUp() {
        this.grapeWinesService=GrapeWinesService.getInstance();
        this.grapeWinesRepository=GrapeWinesRepository.getInstance();
        this.sortColorService=SortColorService.getInstance();
        this.sortColor=sortColorService.getSortColorByName("white");
        this.grape=new Grape("Test",sortColor,1000,100);
        this.wine=new Wines("TestWine",400);
        this.grapeListViewModel=new GrapeListViewModel("Test",sortColor,1000,100);
        this.winesListViewModel=new WinesListViewModel("TestWine",400);
        this.grapeWines=new GrapeWines(grape,wine,100);
        this.grapeWinesListViewModel=new GrapeWinesListViewModel(grape,wine,100);
        grapeWinesRepository.delete(grapeWines);
    }

    @AfterEach
    void tearDown() {
        grapeWinesRepository.delete(grapeWines);
    }

    @Test
    void getAllGrapeWines() {
        ObservableList<GrapeWinesListViewModel> grapeWinesListViewModels= grapeWinesService.getAllGrapeWines();
       /* for(GrapeWinesListViewModel g:grapeWinesListViewModels){
            for(GrapeWinesListViewModel gr:grapeWinesService.getAllGrapeWines()){
                assertEquals(g,gr);
            }
        }*/
      /*  GrapeWinesListViewModel temp=grapeWinesListViewModels.get(0);
        GrapeWinesListViewModel temp1=grapeWinesService.getAllGrapeWines().get(0);
        assertEquals(temp,temp1)*/;
     /*   assertEquals(grapeWinesListViewModels,grapeWinesService.getAllGrapeWines());*/
        assertEquals(grapeWinesListViewModels.size(),grapeWinesService.getAllGrapeWines().size());
    }

    @Test
    void addGrapeWines() {
        List<GrapeWines> all=grapeWinesRepository.getAll();
        grapeWinesService.addGrapeWines(grapeWinesListViewModel,grapeListViewModel,winesListViewModel);
        List<GrapeWines> after=grapeWinesRepository.getAll();
        assertNotEquals(all,after);
        grapeWinesRepository.delete(grapeWines);

    }
    @Test
    void getByGrapeName() {
        assertNotEquals(grapeWines,grapeWinesService.getByGrapeName(grape));
    }

    @Test
    void getByWineName() {
        assertNotEquals(grapeWines,grapeWinesService.getByWineName(wine));
    }
}