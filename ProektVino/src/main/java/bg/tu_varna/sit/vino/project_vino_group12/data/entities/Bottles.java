package bg.tu_varna.sit.vino.project_vino_group12.data.entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Table(name="bottles")
@Entity
public class Bottles implements Serializable {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id_bottle",nullable = false)
    private int id_bottles;

    @Column(name="bottle_size",nullable = true)
    private int bottle_size;

    @Column(name="bottle_quantity",nullable = true)
    private int bottle_quantity;

    @OneToMany(mappedBy = "bottle")
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private Set<Production> production;

    public Bottles(){}

    public Bottles(int bottle_size,int bottle_quantity)
    {
        this.bottle_size=bottle_size;
        this.bottle_quantity=bottle_quantity;
    }

    public int getId_bottle() {
        return id_bottles;
    }

    public void setId_bottle(int id_bottles) {
        this.id_bottles = id_bottles;
    }

    public int getBottle_size() {
        return bottle_size;
    }

    public void setBottle_size(int bottle_size) {
        this.bottle_size = bottle_size;
    }

    public int getBottle_quantity() {
        return bottle_quantity;
    }

    public void setBottle_quantity(int bottle_quantity) {
        this.bottle_quantity = bottle_quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bottles bottles = (Bottles) o;
        return bottle_size == bottles.bottle_size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bottle_size);
    }

    public Set<Production> getProduction() {
        return production;
    }

    public void setProduction(Set<Production> production) {
        this.production = production;
    }

    @Override
    public String toString() {
        return bottle_size+"ml";
    }
}
