package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.*;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.*;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.BottlesListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.ProductionListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.WinesListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductionService {
    private final ProductionRepository repository = ProductionRepository.getInstance();
    public static ProductionService getInstance() {
        return ProductionServiceHolder.INSTANCE;
    }
    public final BottlesRepository bottlesRepository=BottlesRepository.getInstance();
    public final GrapeRepository grapeRepository=GrapeRepository.getInstance();
    public final WinesRepository winesRepository=WinesRepository.getInstance();
    public final BottlesService bottlesService=BottlesService.getInstance();
    private static final org.apache.log4j.Logger log = Logger.getLogger(ProductionService.class);
    private static class ProductionServiceHolder {
        public static final ProductionService INSTANCE = new ProductionService();
    }
    public boolean deleteProduction(ProductionListViewModel production) {
        Production p=getProduction(production);
        if(p==null){
            return false;
        }
        try{
            repository.delete(p);
            log.info("Successfully deleted production: "+p.getId_production());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            log.error("Error deleting production cycle: "+p.getId_production()+" - "+e);
            return false;
        }
    }



   public ObservableList<ProductionListViewModel> getAllProductions() {
        List<Production> productions = repository.getAll();

        return FXCollections.observableList(
                productions.stream().map(p -> new ProductionListViewModel(
                    p.getWine(),
                    p.getBottle(),
                    p.getProduced_bottles()
        )).collect(Collectors.toList()));
    }
    public Production getProduction(ProductionListViewModel production){
        WinesService winesService=WinesService.getInstance();
        List<Production> all=repository.getAll();
        Production temp=new Production(winesService.getWineByName(production.getWines().getName_wine()), bottlesService.getBottleBySize(production.getBottles().getBottle_size()), production.getProduced_bottles());
        for(Production p:all){
            if(p.equals(temp)){ //dava che this.wine e null
                return p;
            }
        }
        log.info("No such production");
        return null;
    }
    public boolean checkIfWineIsInProduction(Wines wine){
        List<Production> productions=repository.getAll();
        for(Production p:productions){
            if(p.getWine().equals(wine)){
                return true;
            }
        }
        log.info("Wine: "+wine.getName_wine()+" not in production");
        return false;
    }
    public int addProduction(ProductionListViewModel p, WinesListViewModel w,BottlesListViewModel b)
    {
        WinesService winesService=WinesService.getInstance();
        Wines wine=winesService.getWineByName(w.getName_wine());
      /*  int total=wine.getTotal();*/
        /*List<Bottles> allBottles=new ArrayList<>();
        allBottles=bottlesRepository.getAll();
        int sum;
        List<Integer> listNumberBottles=new LinkedList<>();
        Bottles temp=new Bottles();
        for(int i=0;i<allBottles.size();i++){
            int br=0;
            sum=allBottles.get(i).getBottle_size()/1000;
            int bQuantity=allBottles.get(i).getBottle_quantity();
            while(total>=0 && bQuantity>0){
                total-=sum;
                br++;
                bQuantity--;
            }
            total=wine.getTotal();
            listNumberBottles.add(br);
        }
        for(int i=0;i<allBottles.size();i++){
            if(total % allBottles.get(i).getBottle_size()/1000*listNumberBottles.get(i) > total % allBottles.get(i+1).getBottle_size()/1000*listNumberBottles.get(i+1)){
                temp=bottlesService.getBottleBySize(allBottles.get(i+1).getBottle_size());
                temp.setBottle_quantity(temp.getBottle_quantity()-listNumberBottles.get(i+1));
            }
        }*/
        Bottles bottle=bottlesService.getBottleBySize(b.getBottle_size());
        Production production=new Production(wine,bottle/*temp*/,p.getProduced_bottles());
        //update-va br butilki v sklada sled proizvodstvo
        int bottle_quantity=production.getBottle().getBottle_quantity();

        bottle_quantity=bottle_quantity-production.getProduced_bottles();
        //check if there are enough bottles
        if(bottle_quantity<=50 || bottle_quantity<=production.getProduced_bottles()) {
            log.error("Not enough bottles for production!");
            return 0;
        }
        else{
            production.getBottle().setBottle_quantity(bottle_quantity);
            //update-va total v wine sled butilirane
            int total = production.getWine().getTotal();
            total = (total - (production.getProduced_bottles() * production.getBottle().getBottle_size()) / 1000);
            //check if there is enough wine to be bottled
            if(total<=0)
            {
                log.error("Not enough wine for production!");
                return 2;
            }
            else{
                production.getWine().setTotal(total);
                try {
                    winesRepository.update(production.getWine());//zapazvane na noviq total na vinoto
                    log.info("Wine :"+production.getWine().getName_wine()+" quantity updated successfully!");
                    bottlesRepository.update(production.getBottle());//zapazvane na novoto kolichestvo butilki
                    log.info("Bottle :"+production.getBottle().getBottle_size()+" quantity updated successfully!");
                    repository.save(production);
                    log.info("Production created successfully!");
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Create production error: "+e);
                }
                return 1;
            }
        }
    }
}
