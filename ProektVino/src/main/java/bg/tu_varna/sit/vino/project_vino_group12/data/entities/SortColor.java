package bg.tu_varna.sit.vino.project_vino_group12.data.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table(name="sort_color")
@Entity
public class SortColor implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id_sort_color",nullable = false)
    private int id_sort_color;

    @Column(name="color")
    private String color;

    @OneToMany(mappedBy = "sortColor")
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private Set<Grape> grapes=new HashSet<Grape>();

    public SortColor(){}

    public SortColor(String color){
       this.color=color;
   }

    public SortColor(String color,Set<Grape> grapes){
        this.color=color;
        this.grapes=grapes;
    }

    public int getId_sort_color() {
        return id_sort_color;
    }

    public void setId_sort_color(int id_sort_color) {
        this.id_sort_color = id_sort_color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<Grape> getGrapes() {
        return grapes;
    }

    public void setGrapes(Set<Grape> grapes) {
        this.grapes = grapes;
    }

    public void addGrape(Grape g){
        this.grapes.add(g);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SortColor sortColor = (SortColor) o;
        return Objects.equals(color, sortColor.color) && Objects.equals(grapes, sortColor.grapes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return color;
    }
}
