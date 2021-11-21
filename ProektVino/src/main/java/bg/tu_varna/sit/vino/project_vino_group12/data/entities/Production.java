package bg.tu_varna.sit.vino.project_vino_group12.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table(name = "production")
@Entity
public class Production implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id_production",nullable = false)
    private int id_production;

    @OneToMany(mappedBy = "production")
    private Set<Wines> wines;

    @OneToMany(mappedBy = "production")
    private Set<Bottles> bottles;

    @Column(name="produced_bottles",nullable = false)
    private int produced_bottles;

    public int getId_production() {
        return id_production;
    }

    public void setId_production(int id_production) {
        this.id_production = id_production;
    }

    public int getProduced_bottles() {
        return produced_bottles;
    }

    public void setProduced_bottles(int produced_bottles) {
        this.produced_bottles = produced_bottles;
    }

    public Set<Wines> getWines() {
        return wines;
    }

    public void setWines(Set<Wines> wines) {
        this.wines = wines;
    }

    public Set<Bottles> getBottles() {
        return bottles;
    }

    public void setBottles(Set<Bottles> bottles) {
        this.bottles = bottles;
    }

    @Override
    public String toString() {
        return "Production{" +
                "id_production=" + id_production +
                ", wines=" + wines +
                ", bottles=" + bottles +
                ", produced_bottles=" + produced_bottles +
                '}';
    }
}
