package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;

import java.util.Set;

public class ProductionListViewModel {
    private Wines wines;
    private Bottles bottles;
    private int produced_bottles;

    public ProductionListViewModel(Wines wines, Bottles bottles, int produced_bottles) {
        this.wines = wines;
        this.bottles = bottles;
        this.produced_bottles = produced_bottles;
    }

    public ProductionListViewModel(int produced_bottles) {
        this.produced_bottles=produced_bottles;
    }

    public Wines getWines() {
        return wines;
    }

    public void setWines(Wines wines) {
        this.wines = wines;
    }

    public Bottles getBottles() {
        return bottles;
    }

    public void setBottles(Bottles bottles) {
        this.bottles = bottles;
    }

    public int getProduced_bottles() {
        return produced_bottles;
    }

    public void setProduced_bottles(int produced_bottles) {
        this.produced_bottles = produced_bottles;
    }

    @Override
    public String toString() {
        return String.format("Wine: %s | Bottle: %s | Produced bottles: %s", wines.getName_wine(), bottles.getBottle_size(), produced_bottles);
    }
}
