package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import java.util.Objects;

public class WinesListViewModel {
    private String name_wine;
    private int total;

    public WinesListViewModel(String name_wine, int total) {
        this.name_wine = name_wine;
        this.total = total;
    }
    public WinesListViewModel(String name_wine){
        this.name_wine=name_wine;
    }

    public String getName_wine() {
        return name_wine;
    }

    public void setName_wine(String name_wine) {
        this.name_wine = name_wine;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinesListViewModel that = (WinesListViewModel) o;
        return total == that.total && Objects.equals(name_wine, that.name_wine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name_wine, total);
    }

    @Override
    public String toString() {
        return String.format("Wine: %s | Quantity in storage: %s", name_wine, total);
    }
}
