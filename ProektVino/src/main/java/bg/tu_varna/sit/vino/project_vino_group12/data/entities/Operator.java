package bg.tu_varna.sit.vino.project_vino_group12.data.entities;

import javax.persistence.*;
import java.io.Serializable;
@Table(name="operator")
@Entity
public class Operator implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id_admin",nullable = false)
    private int id;
}
