package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Admin;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.AdminRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.AdminListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdminService {
    private static final Logger log=Logger.getLogger(AdminService.class);
    private final AdminRepository repository= AdminRepository.getInstance();
    public static AdminService getInstance() {
        return AdminServiceHolder.INSTANCE;
    }


    private static class AdminServiceHolder {
        public static final AdminService INSTANCE = new AdminService();
    }

    public void deleteAdmin(AdminListViewModel admin) {
        Admin a=getAdminByName(admin.getUsername_admin());
        try{
            repository.delete(a);
            log.info("Successfully deleted admin "+a);
        }catch(Exception e){
            e.printStackTrace();
            log.error("Error deleting admin"+a);
        }
    }
    public ObservableList<AdminListViewModel> getAllAdmin() {
        List<Admin> admins=repository.getAll();

        return FXCollections.observableList(
                admins.stream().map(a -> new AdminListViewModel(
                        a.getUsername_admin(),
                        a.getPassword_admin()
                )).collect(Collectors.toList()));
    }
    public boolean adminLogin(AdminListViewModel a)
    {
        if(getAdminByName(a.getUsername_admin())==null){
            log.error("Admin login error!");
            return false;
        }
        log.info("Admin login successful!");
        return true;
    }
    public int createAdmin(AdminListViewModel a){
        Admin admin=new Admin(a.getUsername_admin(),a.getPassword_admin());
        if(checkIfAdminExists(admin)){
            log.info("Admin "+a+" already exists!");
            return 0;
        }
        else {
            try{
                repository.save(admin);
                log.info("Admin "+admin.getUsername_admin()+" created!");
            }
            catch (Exception e) {
                e.printStackTrace();
                log.error("Create admin error!");
            }
            return 1;
        }
    }
    public Admin getAdminByName(String name){
        List<Admin> allAdmins=repository.getAll();
        for(Admin a:allAdmins){
            if(a.getUsername_admin().equals(name))
            {
                return a;
            }
        }
        log.error("Admin not found!");
        return null;
    }
    public boolean checkIfAdminExists(Admin a){
        List<Admin> allAdmins=repository.getAll();
        for(Admin admin:allAdmins){
            if(admin.equals(a))
            {
                log.info("Admin: "+a.getUsername_admin()+" already exists!");
                return true;
            }
        }
        return false;
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
