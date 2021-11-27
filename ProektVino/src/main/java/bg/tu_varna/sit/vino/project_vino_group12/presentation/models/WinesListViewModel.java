package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.GrapeWines;

import java.util.Set;

public class WinesListViewModel {
    private String name_wine;
    private int total;

    public WinesListViewModel(String name_wine, int total) {
        this.name_wine = name_wine;
        this.total = total;
    }

    public String getName_wine() {
        return name_wine;
    }

    public void setName_wine(String name_wine) {
        this.name_wine = name_wine;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return String.format("\t%s\t\t|\t\t%s\t", name_wine, total);
    }
}
