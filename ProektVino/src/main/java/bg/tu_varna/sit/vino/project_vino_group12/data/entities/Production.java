package bg.tu_varna.sit.vino.project_vino_group12.data.entities;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "production")
@Entity
public class Production implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id_production",nullable = false)
    private int id_production;

    @ManyToOne
    @JoinColumn(name="id_wine",nullable = false)
    private Wines wines;

    @ManyToOne
    @JoinColumn(name="id_bottle",nullable = false)
    private Bottles bottles;

    @Column(name="produced_bottles",nullable = false)
    private int produced_bottles;

    public int getId_production() {
        return id_production;
    }

    public void setId_production(int id_production) {
        this.id_production = id_production;
    }

    public Wines getWines() {
        return wines;
    }

    public void setWines(Wines wines) {
        this.wines = wines;
    }

    public Bottles getBottles() {
        return bottles;
    }

    public void setBottles(Bottles bottles) {
        this.bottles = bottles;
    }

    public int getProduced_bottles() {
        return produced_bottles;
    }

    public void setProduced_bottles(int produced_bottles) {
        this.produced_bottles = produced_bottles;
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
