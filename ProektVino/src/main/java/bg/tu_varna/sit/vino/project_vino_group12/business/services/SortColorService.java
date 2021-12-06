package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.SortColor;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.SortColorRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.SortColorListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.annotations.Sort;

import java.util.List;
import java.util.stream.Collectors;

public class SortColorService {
    private final SortColorRepository repository = SortColorRepository.getInstance();
    public static SortColorService getInstance() {
        return SortColorServiceHolder.INSTANSE;
    }

    public void deleteColor(SortColorListViewModel color) {
        SortColor s=getSortColorByName(color.getColor());
        try{
            repository.delete(s);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    private static class SortColorServiceHolder {
        public static final SortColorService INSTANSE = new SortColorService();
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
        return false;
    }
    public int addSortColor(SortColorListViewModel sc){
        SortColor sortColor=new SortColor(sc.getColor());
        if(checkSortColor(sortColor)){
            return 0;
        }
        else {
            try {
                repository.save(sortColor);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 1;
        }
    }
    public SortColor getSortColorByName(String name){
        List<SortColor> allColors=repository.getAll();
        SortColor temp=new SortColor();
        for(SortColor s:allColors){
            if(s.getColor().equals(name))
            {
                temp=s;
            }
        }
        return temp;
    }

}
