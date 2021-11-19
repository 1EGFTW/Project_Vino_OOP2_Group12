package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Admin;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.AdminRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.AdminListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.AdminLoginController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.boot.spi.AbstractDelegatingMetadataBuilderImplementor;

import java.util.List;
import java.util.stream.Collectors;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.ADMIN_VIEW;

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
    public void adminLogin(AdminListViewModel a)
    {
        ObservableList<AdminListViewModel> allAdmins= getAllAdmin();
        for (AdminListViewModel admin:allAdmins)
        {
            if(admin.equals(a))
            {
                logIn=true;
            }
        }
        if(logIn)
        {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADMIN_VIEW));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
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
