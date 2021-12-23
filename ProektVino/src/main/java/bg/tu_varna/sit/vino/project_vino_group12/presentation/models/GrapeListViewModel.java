package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.SortColor;
import java.util.Objects;

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

    public GrapeListViewModel() {
    }

    public GrapeListViewModel(String name_sort, int sort_quantity, int quantity_by_kg) {
        this.name_sort=name_sort;
        this.sort_quantity=sort_quantity;
        this.quantity_by_kg=quantity_by_kg;
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

    public SortColor getSortColor() {
        return sortColor;
    }

    public void setSortColor(SortColor sortColor) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrapeListViewModel that = (GrapeListViewModel) o;
        return sort_quantity == that.sort_quantity && quantity_by_kg == that.quantity_by_kg && Objects.equals(name_sort, that.name_sort) && Objects.equals(sortColor, that.sortColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name_sort, sortColor, sort_quantity, quantity_by_kg);
    }

    @Override
    public String toString() {
        return String.format("%s | %s | quantity in storage: %s ", name_sort, sortColor, sort_quantity);
    }
}
