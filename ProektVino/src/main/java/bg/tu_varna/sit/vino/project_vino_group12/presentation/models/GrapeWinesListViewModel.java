package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;

import java.util.Set;

public class GrapeWinesListViewModel {
    private GrapeListViewModel grape;
    private WinesListViewModel wine;
    private int quantity_for_wine;
    public GrapeWinesListViewModel(GrapeListViewModel grape, WinesListViewModel wine, int quantity_for_wine) {
        this.grape=grape;
        this.wine=wine;
        this.quantity_for_wine=quantity_for_wine;
    }

    public GrapeWinesListViewModel() {

    }

    public GrapeListViewModel getGrape() {
        return grape;
    }

    public void setGrape(GrapeListViewModel grape) {
        this.grape = grape;
    }

    public WinesListViewModel getWine() {
        return wine;
    }

    public void setWine(WinesListViewModel wine) {
        this.wine = wine;
    }

    public int getQuantity_for_wine() {
        return quantity_for_wine;
    }

    public void setQuantity_for_wine(int quantity_for_wine) {
        this.quantity_for_wine = quantity_for_wine;
    }
}
