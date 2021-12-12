package bg.tu_varna.sit.vino.project_vino_group12.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name="admin")
@Entity
public class Admin implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_admin",nullable = false)
    private int id_admin;

    @Column(name="username_admin",nullable = true)
    private String username_admin;

    @Column(name="password_admin",nullable = true)
    private String password_admin;

    public Admin(String toString, String toString1) {
        this.username_admin = toString;
        this.password_admin = toString1;
    }
    public Admin()
    {

    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId(int id) {
        this.id_admin = id;
    }

    public String getUsername_admin() {
        return username_admin;
    }

    public void setUsername_admin(String username_admin) {
        this.username_admin = username_admin;
    }

    public String getPassword_admin() {
        return password_admin;
    }

    public void setPassword_admin(String password_admin) {
        this.password_admin = password_admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(username_admin, admin.username_admin) && Objects.equals(password_admin, admin.password_admin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username_admin, password_admin);
    }

   
    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id_admin +
                ", username_admin='" + username_admin + '\'' +
                ", password_admin='" + password_admin + '\'' +
                '}';
    }
}

