package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SortColorListViewModel that = (SortColorListViewModel) o;
        return Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return String.format("%s", color);
    }

}
