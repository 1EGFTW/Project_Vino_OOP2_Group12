package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.SortColor;

public class GrapeListViewModel {
    private String name_sort;
    private SortColor sortColor;
    private int sort_quantity;
    private int quantity_by_kg;

    public GrapeListViewModel(String name_sort, SortColor sortColor, int sort_quantity, int quantity_by_kg){
        this.name_sort = name_sort;
        this.sortColor = sortColor;
        this.sort_quantity = sort_quantity;
        this.quantity_by_kg = quantity_by_kg;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s", name_sort, sortColor, sort_quantity, quantity_by_kg);
    }
}
