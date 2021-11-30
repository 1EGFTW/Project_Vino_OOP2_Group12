package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Admin;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.AdminRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.AdminListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
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
    public List<String> checkAvailableBottles(){
        BottlesService bottlesService=BottlesService.getInstance();
        List<Bottles> bottles=bottlesService.checkCriticalLevels();
        List<String> critical=new ArrayList<>();
        for(Bottles b:bottles){
            critical.add(String.valueOf(b.getBottle_size()));
        }
        return critical;
    }
    public List<String> checkAvailableGrapes(){
        GrapeService grapeService=GrapeService.getInstance();
        List<Grape> grapes=grapeService.checkCriticalLevels();
        List<String> critical=new ArrayList<>();
        for(Grape g:grapes){
            critical.add(g.getName_sort());
        }
        return critical;
    }


}
