package bg.tu_varna.sit.vino.project_vino_group12.data.entities;

import org.hibernate.annotations.Cascade;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "id_wine")
    private Wines wine;

    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "id_bottle")
    private Bottles bottle;

    @Column(name="produced_bottles",nullable = false)
    private int produced_bottles;
    public Production(){
    }
    public Production(int produced_bottles){
        this.produced_bottles=produced_bottles;
    }

    public Production(Wines wine, Bottles bottle, int  produced_bottles) {
        this.wine=wine;
        this.bottle=bottle;
        this.produced_bottles=produced_bottles;
    }

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

    public Wines getWine() {
        return wine;
    }

    public void setWine(Wines wine) {
        this.wine = wine;
    }

    public Bottles getBottle() {
        return bottle;
    }

    public void setBottle(Bottles bottle) {
        this.bottle = bottle;
    }

    public boolean equals(Production r){
        return this.wine.equals(r.wine)&&this.bottle.equals(r.bottle)&&this.produced_bottles==r.produced_bottles;
    }
    @Override
    public String toString() {
        return "Production{" +
                "id_production=" + id_production +
                ", wine=" + wine +
                ", bottle=" + bottle +
                ", produced_bottles=" + produced_bottles +
                '}';
    }
}
