package bg.tu_varna.sit.vino.project_vino_group12.data.entities;

import javax.persistence.*;
import java.io.Serializable;
@Table(name="operator")
@Entity
public class Operator implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_operator",nullable = false)
    private int id_operator;

    @Column(name="username_operator",nullable = true)
    private String username_operator;

    @Column(name="password_operator",nullable = true)
    private String password_operator;

    public Operator(String toString, String toString1) {
        this.username_operator=toString;
        this.password_operator=toString1;
    }

    public int getId_operator() {
        return id_operator;
    }

    public void setId_operator(int id_operator) {
        this.id_operator = id_operator;
    }

    public String getUsername_operator() {
        return username_operator;
    }

    public void setUsername_operator(String username_operator) {
        this.username_operator = username_operator;
    }

    public String getPassword_operator() {
        return password_operator;
    }

    public void setPassword_operator(String password_operator) {
        this.password_operator = password_operator;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id_operator=" + id_operator +
                ", username_operator='" + username_operator + '\'' +
                ", password_operator='" + password_operator + '\'' +
                '}';
    }
}
