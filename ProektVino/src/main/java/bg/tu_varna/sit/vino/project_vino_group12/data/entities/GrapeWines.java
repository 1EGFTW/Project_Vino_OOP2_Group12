package bg.tu_varna.sit.vino.project_vino_group12.data.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="grozde_wine")
public class GrapeWines implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_sort_wine")
    private int id_sort_wines;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="id_sort")
    private Grape grape;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="id_wine")
    private Wines wine;

    @Column(name="quantity_for_wine")
    private int quantity_for_wine;

    public GrapeWines(){}

    public GrapeWines(Grape grape, Wines wine, int quantity_for_wine) {
        this.grape = grape;
        this.wine = wine;
        this.quantity_for_wine = quantity_for_wine;
    }

    public int getId_sort_wines() {
        return id_sort_wines;
    }

    public void setId_sort_wines(int id_sort_wines) {
        this.id_sort_wines = id_sort_wines;
    }

    public Grape getGrape() {
        return grape;
    }

    public void setGrape(Grape grape) {
        this.grape = grape;
    }

    public Wines getWine() {
        return wine;
    }

    public void setWine(Wines wine) {
        this.wine = wine;
    }

    public int getQuantity_for_wine() {
        return quantity_for_wine;
    }

    public void setQuantity_for_wine(int quantity_for_wine) {
        this.quantity_for_wine = quantity_for_wine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrapeWines that = (GrapeWines) o;
        return quantity_for_wine == that.quantity_for_wine && Objects.equals(grape, that.grape) && Objects.equals(wine, that.wine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grape, wine, quantity_for_wine);
    }
}
