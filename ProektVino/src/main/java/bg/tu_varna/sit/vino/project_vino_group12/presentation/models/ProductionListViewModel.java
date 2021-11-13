package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;

public class ProductionListViewModel {
    private Wines wines;
    private Bottles bottles;
    private int produces_bottles;

    public ProductionListViewModel(Wines wines, Bottles bottles, int produces_bottles) {
        this.wines = wines;
        this.bottles = bottles;
        this.produces_bottles = produces_bottles;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s", wines, bottles, produces_bottles);
    }
}
