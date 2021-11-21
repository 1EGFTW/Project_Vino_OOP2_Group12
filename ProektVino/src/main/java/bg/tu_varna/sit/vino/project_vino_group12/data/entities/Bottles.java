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
    private int id_bottle;

    @Column(name="bottle_size",nullable = true)
    private int bottle_size;

    @Column(name="bottle_quantity",nullable = true)
    private int bottle_quantity;

   @ManyToOne
   @JoinColumn(name = "id_bottle")
   private Production production;

    public Bottles(int bottle_size,int bottle_quantity)
    {
        this.bottle_size=bottle_size;
        this.bottle_quantity=bottle_quantity;
    }

    public int getId_bottle() {
        return id_bottle;
    }

    public void setId_bottle(int id_bottle) {
        this.id_bottle = id_bottle;
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

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    @Override
    public String toString() {
        return "Bottles{" +
                "id_bottle=" + id_bottle +
                ", bottle_size=" + bottle_size +
                ", bottle_quantity=" + bottle_quantity +
                ", production=" + production +
                '}';
    }
}
