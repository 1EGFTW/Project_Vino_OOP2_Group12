package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;

import java.util.Set;

public class GrapeWinesListViewModel {
    public Grape grape;
    public Wines wine;
    public int quantity_for_wine;
    public GrapeWinesListViewModel(Grape grape, Wines wine, int quantity_for_wine) {
        this.grape=grape;
        this.wine=wine;
        this.quantity_for_wine=quantity_for_wine;
    }

}
