package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

public class AdminListViewModel {
    private String username_admin;
    private String password_admin;

    public AdminListViewModel(String username_admin, String password_admin) {
        this.username_admin = username_admin;
        this.password_admin = password_admin;
    }

    @Override
    public String toString() {
        return String.format("%s | %s",username_admin,password_admin);
    }

}