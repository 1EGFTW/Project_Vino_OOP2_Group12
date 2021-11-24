package bg.tu_varna.sit.vino.project_vino_group12.data.entities;

import org.hibernate.annotations.Sort;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Table(name="grozde")
@Entity
public class Grape implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_sort",nullable = false)
    private int id_sort;

    @Column(name="name_sort")
    private String name_sort;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sort_color")
    private SortColor sortColor;

    @Column(name="sort_quantity")
    private int sort_quantity;

    @Column(name="quantity_by_kg")
    private int quantity_by_kg;

    @OneToMany(mappedBy = "grape")
    private Set<GrapeWines> grapeWines;

    public Grape(){

    }
    public Grape(String name_sort,SortColor sortcolor, int sort_quantity,int quantity_by_kg){
        this.name_sort=name_sort;
        this.sortColor=sortcolor;
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
    public Set<GrapeWines> getGrapeWines(){
        return grapeWines;
    }
    public void setGrapeWines(Set<GrapeWines> wines){
        this.grapeWines=wines;
    }
    public void addWine(GrapeWines wine){
        this.grapeWines.add(wine);
    }
    public void addGrapeWines(GrapeWines grapeWines){
        this.grapeWines.add(grapeWines);
    }
}
