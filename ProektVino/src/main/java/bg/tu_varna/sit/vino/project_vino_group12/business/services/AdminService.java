package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Admin;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.AdminRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.AdminListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.AdminLoginController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.boot.spi.AbstractDelegatingMetadataBuilderImplementor;

import java.util.List;
import java.util.stream.Collectors;

public class AdminService {
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

}
