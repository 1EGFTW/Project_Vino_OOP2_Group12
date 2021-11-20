package bg.tu_varna.sit.vino.project_vino_group12.data.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="grozde_wines")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.grape",
                joinColumns = @JoinColumn(name = "id_sort")),
        @AssociationOverride(name = "primaryKey.wine",
                joinColumns = @JoinColumn(name = "id_wine")) })
public class GrapeWines implements Serializable {
    @EmbeddedId
    private GrapeWinesId primaryKey=new GrapeWinesId();
    @Column(name="quantity_for_wine")
    private int quantity_for_wine;

    public GrapeWinesId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(GrapeWinesId primaryKey) {
        this.primaryKey = primaryKey;
    }

    public int getQuantity_for_wine() {
        return quantity_for_wine;
    }

    public void setQuantity_for_wine(int quantity_for_wine) {
        this.quantity_for_wine = quantity_for_wine;
    }
    @Transient
    public Grape getGrape(){
        return getPrimaryKey().getGrape();
    }
    public void setGrape(Grape grape){
        getPrimaryKey().setGrape(grape);
    }
    @Transient
    public Wines getWines(){
        return getPrimaryKey().getWine();
    }
    public void setWines(Wines wines){
        getPrimaryKey().setWine(wines);
    }
}
