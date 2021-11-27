package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

public class AdminListViewModel {
    private String username_admin;
    private String password_admin;

    public AdminListViewModel(String username_admin, String password_admin) {
        this.username_admin = username_admin;
        this.password_admin = password_admin;
    }

    public boolean equals(AdminListViewModel r) {
   return this.username_admin.equals(r.username_admin)&& this.password_admin.equals(r.password_admin);
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
        return String.format("%s | %s",username_admin,password_admin);
    }

}
