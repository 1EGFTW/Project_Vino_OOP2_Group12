package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.SortColor;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.SortColorRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.SortColorListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;
import org.hibernate.annotations.Sort;

import java.util.List;
import java.util.stream.Collectors;

public class SortColorService {
    private final SortColorRepository repository = SortColorRepository.getInstance();
    private static final Logger log=Logger.getLogger(SortColorService.class);
    public static SortColorService getInstance() {
        return SortColorServiceHolder.INSTANSE;
    }
    private static class SortColorServiceHolder {
        public static final SortColorService INSTANSE = new SortColorService();
    }

    public void deleteColor(SortColorListViewModel color) {
        SortColor s=getSortColorByName(color.getColor());
        try{
            repository.delete(s);
            log.info("Color: "+s.getColor()+" deleted successfully!");
        }catch(Exception e) {
            e.printStackTrace();
            log.error("Error deleting color: "+s.getColor()+" - "+e);
        }
    }



    public ObservableList<SortColorListViewModel> getAllSortColor() {
        List<SortColor> sortColors = repository.getAll();

        return FXCollections.observableList(
                sortColors.stream().map(s -> new SortColorListViewModel(
                        s.getColor()
                )).collect(Collectors.toList()));
    }
    public boolean checkSortColor(SortColor s){
        List<SortColor> sortColors=repository.getAll();
        for(SortColor sc:sortColors){
            if(sc.equals(s)){
                return true;
            }
        }
        log.error("No such color!");
        return false;
    }
    public int addSortColor(SortColorListViewModel sc){
        SortColor sortColor=new SortColor(sc.getColor());
        if(checkSortColor(sortColor)){
            log.error("Color: "+sortColor.getColor()+" already exists!");
            return 0;
        }
        else {
            try {
                repository.save(sortColor);
                log.info("Color: "+sortColor.getColor()+" created successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Error creating color! - "+e);
            }
            return 1;
        }
    }
    public SortColor getSortColorByName(String name){
        List<SortColor> allColors=repository.getAll();
        for(SortColor s:allColors){
            if(s.getColor().equals(name))
            {
                return s;
            }
        }
        log.error("No such color!");
        return null;
    }

}
