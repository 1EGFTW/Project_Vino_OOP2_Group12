package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.GrapeWines;

import java.util.Set;

public class WinesListViewModel {
    private String name_wine;
    private Set<GrapeWines> grapeWines;
    private int total;

    public WinesListViewModel(String name_wine,Set<GrapeWines> grapeWines, int total) {
        this.name_wine = name_wine;
        this.grapeWines=grapeWines;
        this.total = total;
    }


    @Override
    public String toString() {
        return String.format("%s | %s | %s", name_wine, grapeWines, total);
    }
}
