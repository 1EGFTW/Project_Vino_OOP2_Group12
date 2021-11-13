package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

public class SortColorListViewModel {
    private String color;

    public SortColorListViewModel(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s | %s", color);
    }
}
