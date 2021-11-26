package bg.tu_varna.sit.vino.project_vino_group12.data.entities;

import javax.persistence.*;
import java.io.Serializable;
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
//da se vidi insertable i updatable(hibernate iska da byde tyka
    @OneToMany(mappedBy = "bottle")
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


    public boolean equals(Bottles r){
        return this.bottle_size==r.bottle_size;
    }

    public int getId_bottles() {
        return id_bottles;
    }

    public void setId_bottles(int id_bottles) {
        this.id_bottles = id_bottles;
    }

    public Set<Production> getProduction() {
        return production;
    }

    public void setProduction(Set<Production> production) {
        this.production = production;
    }
}
