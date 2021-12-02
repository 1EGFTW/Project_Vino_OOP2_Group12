package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.SortColor;
import javafx.scene.control.Label;

public class GrapeListViewModel {
    private String name_sort;
    private SortColorListViewModel sortColor;
    private int sort_quantity;
    private int quantity_by_kg;

    public GrapeListViewModel(String name_sort, SortColorListViewModel sortColor, int sort_quantity, int quantity_by_kg){
        this.name_sort = name_sort;
        this.sortColor = sortColor;
        this.sort_quantity = sort_quantity;
        this.quantity_by_kg = quantity_by_kg;
    }

    public GrapeListViewModel() {
    }


    public boolean equals(GrapeListViewModel r){
        return this.name_sort.equals(r.name_sort) && this.sortColor.equals(r.sortColor);
    }

    public String getName_sort() {
        return name_sort;
    }

    public void setName_sort(String name_sort) {
        this.name_sort = name_sort;
    }

    public SortColorListViewModel getSortColor() {
        return sortColor;
    }

    public void setSortColor(SortColorListViewModel sortColor) {
        this.sortColor = sortColor;
    }

    public int getSort_quantity() {
        return sort_quantity;
    }

    public void setSort_quantity(int sort_quantity) {
        this.sort_quantity = sort_quantity;
    }

    public int getQuantity_by_kg() {
        return quantity_by_kg;
    }

    public void setQuantity_by_kg(int quantity_by_kg) {
        this.quantity_by_kg = quantity_by_kg;
    }

    @Override
    public String toString() {
        return String.format("%s\t\t  |\t\t %s\t\t|\t\t%s\t\t|\t\t%s", name_sort, sortColor, sort_quantity, quantity_by_kg);
    }
}
