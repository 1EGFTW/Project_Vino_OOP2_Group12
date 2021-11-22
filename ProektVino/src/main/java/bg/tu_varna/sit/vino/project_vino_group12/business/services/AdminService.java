package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Admin;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.AdminRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.AdminListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;
import java.util.stream.Collectors;

public class AdminService {
    public boolean logIn=false;
    private final AdminRepository repository= AdminRepository.getInstance();
    public static AdminService getInstance() {
        return AdminServiceHolder.INSTANCE;
    }

    private static class AdminServiceHolder {
        public static final AdminService INSTANCE = new AdminService();
    }

    public ObservableList<AdminListViewModel> getAllAdmin() { //spisyk s admini
        List<Admin> admins=repository.getAll();

        return FXCollections.observableList(
                admins.stream().map(a -> new AdminListViewModel(
                        a.getUsername_admin(),
                        a.getPassword_admin()
                )).collect(Collectors.toList()));
    }
    public boolean adminLogin(AdminListViewModel a)
    {
        ObservableList<AdminListViewModel> allAdmins= getAllAdmin();
        for (AdminListViewModel admin:allAdmins)
        {
            if(admin.equals(a))
            {
                return true;
            }
        }
        return false;
    }
    public void createAdmin(Admin a){
        try{
            repository.save(a);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
