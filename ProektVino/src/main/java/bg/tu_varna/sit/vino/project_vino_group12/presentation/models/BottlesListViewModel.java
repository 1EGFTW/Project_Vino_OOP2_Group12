package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

public class BottlesListViewModel {
    private int bottle_size;
    private int bottle_quantity;

    public BottlesListViewModel(int bottle_size, int bottle_quantity){
        this.bottle_size = bottle_size;
        this.bottle_quantity = bottle_quantity;
    }

    @Override
    public String toString() {
        return String.format("%s | %s", bottle_size, bottle_quantity);
    }
}
