package bg.tu_varna.sit.vino.project_vino_group12.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Table(name="wines")
@Entity
public class Wines implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_wine",nullable = false)
    private int id_wine;

    @Column(name = "name_wine",nullable = false)
    private String name_wine;

    @OneToMany(mappedBy = "wine")
    private Set<GrapeWines> grapeWines=new HashSet<>();

    @Column(name="total",nullable = false)
    private int total;

    @ManyToOne
    @JoinColumn(name = "id_production")
    private Production production;

    public Wines(){

    }
    public Wines(String name_wine,int total)
    {
        this.name_wine=name_wine;
        this.total=total;
    }

    public int getId_wine() {
        return id_wine;
    }

    public void setId_wine(int id_wine) {
        this.id_wine = id_wine;
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
    public Set<GrapeWines> getGrapeWines(){
        return grapeWines;
    }
    public void setGrapeWines(Set<GrapeWines> wines){
        this.grapeWines=wines;
    }
    public void addGrapeWines(GrapeWines grapeWines){
        this.grapeWines.add(grapeWines);
    }
}
