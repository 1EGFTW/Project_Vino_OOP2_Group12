package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.*;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeRepository;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeWinesRepository;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.SortColorRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.GrapeListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.SortColorListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.WinesListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.annotations.Sort;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GrapeService {
    private final GrapeRepository grapeRepository = GrapeRepository.getInstance();
    private final GrapeWinesService grapeWinesService=GrapeWinesService.getInstance();
    private final GrapeWinesRepository grapeWinesRepository=GrapeWinesRepository.getInstance();
    public static GrapeService getInstance() {
        return GrapeServiceHolder.INSTANCE;
    }
    private static class GrapeServiceHolder {
        public static final GrapeService INSTANCE = new GrapeService();
    }

    private final SortColorService sortColorService = SortColorService.getInstance();

    public void deleteGrape(GrapeListViewModel grape) {
        Grape g=getGrapeByName(grape.getName_sort());
        GrapeWines grapeWines=grapeWinesService.getByGrapeName(g);
        try{
            grapeWinesRepository.delete(grapeWines);
            grapeRepository.delete(g);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public ObservableList<GrapeListViewModel> getAllGrape() {
        List<Grape> grapes = grapeRepository.getAll();

        return FXCollections.observableList(
                grapes.stream().map(g -> new GrapeListViewModel(
                        g.getName_sort(),
                        g.getSortColor(),
                        g.getSort_quantity(),
                        g.getQuantity_by_kg()
                )).collect(Collectors.toList()));
    }

    public int addGrape(GrapeListViewModel g,SortColorListViewModel s) {
        SortColor sc = sortColorService.getSortColorByName(s.getColor());
        Grape temp = new Grape(g.getName_sort(), sc, g.getSort_quantity(), g.getQuantity_by_kg());
        if(checkIfGrapeExists(temp)){
            return 0;
        }
        else {
            try {
                grapeRepository.save(temp);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 1;
        }
    }
    public boolean checkIfGrapeExists(Grape g){
        List<Grape> allGrapes=grapeRepository.getAll();
        for(Grape grape:allGrapes){
            if(grape.equals(g)){
                return true;
            }
        }
        return false;
    }
    public Grape getGrapeByName(String name) {
        List<Grape> grapes = grapeRepository.getAll();
        Grape temp = new Grape();
        for (Grape g : grapes) {
            if (g.getName_sort().equals(name)) {
                temp = g;
            }
        }
        return temp;
    }
    public List<Grape> checkCriticalLevels(){
        List<Grape> allGrapes=grapeRepository.getAll();
        List<Grape> temp=new LinkedList<>();
        for(Grape grape:allGrapes)
        {
            if(grape.getSort_quantity()<=50)
            {
                temp.add(grape);
            }
        }
        return temp;
    }

    public boolean updateGrape(GrapeListViewModel g,int q){
        Grape grape=getGrapeByName(g.getName_sort());
        int quantity=grape.getSort_quantity()+q;
        grape.setSort_quantity(quantity);
        try{
            grapeRepository.update(grape);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
