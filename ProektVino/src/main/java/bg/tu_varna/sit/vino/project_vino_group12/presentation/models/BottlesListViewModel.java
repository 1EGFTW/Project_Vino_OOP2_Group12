package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import java.util.Objects;

public class BottlesListViewModel {
    private int bottle_size;
    private int bottle_quantity;

    public BottlesListViewModel(int bottle_size, int bottle_quantity){
        this.bottle_size = bottle_size;
        this.bottle_quantity = bottle_quantity;
    }

    public int getBottle_size() {
        return bottle_size;
    }

    public void setBottle_size(int bottle_size) {
        this.bottle_size = bottle_size;
    }

    public int getBottle_quantity() {
        return bottle_quantity;
    }

    public void setBottle_quantity(int bottle_quantity) {
        this.bottle_quantity = bottle_quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BottlesListViewModel that = (BottlesListViewModel) o;
        return bottle_size == that.bottle_size && bottle_quantity == that.bottle_quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bottle_size, bottle_quantity);
    }

    @Override
    public String toString() {
        return String.format("Bottle: %s ml | %s pieces", bottle_size, bottle_quantity);
    }
}
