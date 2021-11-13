package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;

public class WinesListViewModel {
    private String name_wine;
    private Grape id_sort;
    private int total;

    public WinesListViewModel(String name_wine, Grape id_sort, int total) {
        this.name_wine = name_wine;
        this.id_sort = id_sort;
        this.total = total;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s", name_wine, id_sort, total);
    }
}
