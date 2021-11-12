package bg.tu_varna.sit.vino.project_vino_group12.data.entities;

import javax.persistence.*;
import java.io.Serializable;
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

    @ManyToOne
    @JoinColumn(name="id_sort",nullable = false)
    private Grape id_sort;

    @Column(name="total",nullable = false)
    private int total;

    @OneToMany(mappedBy = "wines")
    private Set<Production> productionSet;

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

    public Grape getId_sort() {
        return id_sort;
    }

    public void setId_sort(Grape id_sort) {
        this.id_sort = id_sort;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Set<Production> getProductionSet() {
        return productionSet;
    }

    public void setProductionSet(Set<Production> productionSet) {
        this.productionSet = productionSet;
    }

    @Override
    public String toString() {
        return "Wines{" +
                "id_wine=" + id_wine +
                ", name_wine='" + name_wine + '\'' +
                ", id_sort=" + id_sort +
                ", total=" + total +
                ", productionSet=" + productionSet +
                '}';
    }
}
