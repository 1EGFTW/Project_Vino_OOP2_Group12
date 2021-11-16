package bg.tu_varna.sit.vino.project_vino_group12.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table(name="grozde")
@Entity
public class Grape implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id_sort",nullable = false)
    private int id_sort;

    @Column(name="name_sort",nullable = true)
    private String name_sort;

    @ManyToOne
    @JoinColumn(name="id_sort_color",nullable = false)
    private SortColor sortColor;

    @Column(name="sort_quantity",nullable = false)
    private int sort_quantity;

    @Column(name="quantity_by_kg",nullable = false)
    private int quantity_by_kg;

    @OneToMany(mappedBy = "id_sort")
    private Set<Wines> winesSet;

    public Grape(String name_sort,SortColor sortColor,int sort_quantity,int quantity_by_kg)
    {
        this.name_sort=name_sort;
        this.sortColor=sortColor;
        this.sort_quantity=sort_quantity;
        this.quantity_by_kg=quantity_by_kg;
    }

    public int getId_sort() {
        return id_sort;
    }

    public void setId_sort(int id_sort) {
        this.id_sort = id_sort;
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

    public Set<Wines> getWinesSet() {
        return winesSet;
    }

    public void setWinesSet(Set<Wines> winesSet) {
        this.winesSet = winesSet;
    }

    @Override
    public String toString() {
        return "Grape{" +
                "id_sort=" + id_sort +
                ", name_sort='" + name_sort + '\'' +
                ", sortColor=" + sortColor +
                ", sort_quantity=" + sort_quantity +
                ", quantity_by_kg=" + quantity_by_kg +
                ", winesSet=" + winesSet +
                '}';
    }
}
