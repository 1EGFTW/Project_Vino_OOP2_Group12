package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

public class WarehouseHostListViewModel {
    private String username_domakin;
    private String password_domakin;

    public WarehouseHostListViewModel(String username_domakin, String password_domakin) {
        this.username_domakin = username_domakin;
        this. password_domakin =password_domakin;
    }

    public boolean equals(WarehouseHostListViewModel r) {
        return this.username_domakin.equals(r.username_domakin)&& this.password_domakin.equals(r.password_domakin);
    }
    @Override
    public String toString() {
        return String.format("%s | %s", username_domakin, password_domakin);
    }

}
