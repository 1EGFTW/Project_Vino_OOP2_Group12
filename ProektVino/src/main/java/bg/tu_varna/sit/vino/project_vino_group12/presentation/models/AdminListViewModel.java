package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import java.util.Objects;

public class AdminListViewModel {
    private String username_admin;
    private String password_admin;

    public AdminListViewModel(){}

    public AdminListViewModel(String username_admin, String password_admin) {
        this.username_admin = username_admin;
        this.password_admin = password_admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminListViewModel that = (AdminListViewModel) o;
        return Objects.equals(username_admin, that.username_admin) && Objects.equals(password_admin, that.password_admin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username_admin, password_admin);
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
    public String toString() {
        return String.format("%s",username_admin);
    }

}
