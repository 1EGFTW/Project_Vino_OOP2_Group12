package bg.tu_varna.sit.vino.project_vino_group12.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table(name="sort_color")
@Entity
public class SortColor implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id_sort_color",nullable = false)
    private int id_sort_color;

    @Column(name="color",nullable = true)
    private String color;

   @OneToMany(mappedBy = "sortColor")
    private Set<Grape> grapeSet;

   public SortColor(String color){
       this.color=color;
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

    public Set<Grape> getGrapeSet() {
        return grapeSet;
    }

    public void setGrapeSet(Set<Grape> grapeSet) {
        this.grapeSet = grapeSet;
    }

    @Override
    public String toString() {
        return "SortColor{" +
                "id_sort_color=" + id_sort_color +
                ", color='" + color + '\'' +
                ", grapeSet=" + grapeSet +
                '}';
    }
}
