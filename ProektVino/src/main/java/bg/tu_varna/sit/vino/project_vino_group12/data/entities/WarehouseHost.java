package bg.tu_varna.sit.vino.project_vino_group12.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name="domakin_sklad")
@Entity
public class WarehouseHost implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id_domakin",nullable = false)
    private int id_domakin;

    @Column(name="username_domakin",nullable = true)
    private String username_domakin;

    @Column(name="password_domakin",nullable = true)
    private String password_domakin;

    public WarehouseHost(String toString, String toString1) {
        this.username_domakin=toString;
        this.password_domakin=toString1;
    }
    public WarehouseHost(){

    }

    public int getId_domakin() {
        return id_domakin;
    }

    public void setId_domakin(int id_domakin) {
        this.id_domakin = id_domakin;
    }

    public String getUsername_domakin() {
        return username_domakin;
    }

    public void setUsername_domakin(String username_domakin) {
        this.username_domakin = username_domakin;
    }

    public String getPassword_domakin() {
        return password_domakin;
    }

    public void setPassword_domakin(String password_domakin) {
        this.password_domakin = password_domakin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarehouseHost that = (WarehouseHost) o;
        return Objects.equals(username_domakin, that.username_domakin) && Objects.equals(password_domakin, that.password_domakin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username_domakin, password_domakin);
    }

    @Override
    public String toString() {
        return "WarehouseHost{" +
                "id_domakin=" + id_domakin +
                ", username_domakin='" + username_domakin + '\'' +
                ", password_domakin='" + password_domakin + '\'' +
                '}';
    }
}
