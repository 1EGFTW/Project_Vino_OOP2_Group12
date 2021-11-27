package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;

public class SortColorListViewModel {
    private String color;

    public SortColorListViewModel(String color) {
        this.color = color;
    }

    public boolean equals(SortColorListViewModel r) {
        return this.color.equals(r.color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s", color);
    }

}
