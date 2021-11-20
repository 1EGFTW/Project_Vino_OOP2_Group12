package bg.tu_varna.sit.vino.project_vino_group12.data.entities;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
@Embeddable
public class GrapeWinesId implements Serializable {
    private Grape grape;
    private Wines wine;

    @ManyToOne(cascade = CascadeType.ALL)
    public Grape getGrape(){
        return grape;
    }
    public void setGrape(Grape grape){
        this.grape=grape;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Wines getWine(){
        return wine;
    }
    public void setWine(Wines wine){
        this.wine=wine;
    }
}
