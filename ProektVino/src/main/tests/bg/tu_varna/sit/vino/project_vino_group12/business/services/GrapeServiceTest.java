package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.SortColor;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.GrapeListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.SortColorListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.xml.bind.SchemaOutputResolver;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrapeServiceTest {
    private Grape grape;
    private GrapeListViewModel grapeListViewModel;
    private GrapeService grapeService;
    private GrapeRepository grapeRepository;
    private SortColor sortColor;
    private SortColorListViewModel sortColorListViewModel;


    @BeforeEach
    void setUp() {
        this.grapeService=GrapeService.getInstance();
        this.grapeRepository=GrapeRepository.getInstance();
        this.sortColor=new SortColor("black");
        this.sortColorListViewModel=new SortColorListViewModel("black");
        this.grape=new Grape("Test",sortColor,1000,100);
        this.grapeListViewModel=new GrapeListViewModel("Test",sortColor,1000,100);
        grapeRepository.delete(grape);
    }

    @AfterEach
    void tearDown() {
        grapeRepository.delete(grape);
    }

    @Test
    void deleteGrape() {
        List<Grape> grapes=grapeRepository.getAll();
        grapeService.deleteGrape(grapeListViewModel);
        assertNotEquals(grapes,grapeRepository.getAll());
    }

    @Test
    void getAllGrape() {
        ObservableList<GrapeListViewModel> grapes= grapeService.getAllGrape();
        assertEquals(grapes.size(),grapeService.getAllGrape().size());
    }

    @Test
    void addGrape() {
        assertEquals(1,grapeService.addGrape(grapeListViewModel,sortColorListViewModel));
    }

    @Test
    void checkIfGrapeExists() {
        assertFalse(grapeService.checkIfGrapeExists(grape));
    }

    @Test
    void getGrapeByName() {
        assertEquals(grape.getName_sort(),grapeService.getGrapeByName(grapeListViewModel.getName_sort()).getName_sort());//??????????
    }

    @Test
    void checkCriticalLevels() {
        List<Grape> res=new LinkedList<>();
        res.add(grape);
        assertNotEquals(res,grapeService.checkCriticalLevels());
    }

    @Test
    void updateGrape() {
        assertTrue(grapeService.updateGrape(grapeListViewModel,1005));
    }
}