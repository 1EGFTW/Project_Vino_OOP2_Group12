package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Admin;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.AdminRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.AdminListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdminServiceTest {
    private AdminService adminService;
    private Admin admin;
    private AdminListViewModel adminListViewModel;
    private Bottles bottle;
    private Grape grape;
    private AdminRepository adminRepository;

    @BeforeEach
    void setUp() {
        adminService=AdminService.getInstance();
        admin=new Admin("1","1");
        admin.setId(9);
        adminListViewModel=new AdminListViewModel("1","1");
        bottle=new Bottles(1000,0);
        grape=new Grape();
        grape.setSort_quantity(40);
        grape.setName_sort("Test");
        adminRepository=AdminRepository.getInstance();
    }
    @Test
    void deleteAdmin(){
        List<Admin> allAdmins=adminRepository.getAll();
        adminService.deleteAdmin(adminListViewModel);
        assertNotEquals(allAdmins,adminRepository.getAll());
    }

    @Test
    void getAllAdmin() {
        ObservableList<AdminListViewModel> allAdmins = adminService.getAllAdmin();
        assertEquals(allAdmins, adminService.getAllAdmin());
    }
    @Test
    void adminLogin() {
        assertTrue(adminService.adminLogin(adminListViewModel));
    }
    @Test
    void checkAvailableBottles(){
        List<String> res=new ArrayList<>();
        res.add(String.valueOf(bottle.getBottle_size()));
        assertEquals(res,adminService.checkAvailableBottles());

    }
    @Test
    void checkAvailableGrapes(){
        List<String> res=new ArrayList<>();
        assertEquals(res,adminService.checkAvailableGrapes());
    }

    @Test
    void createAdmin() {
        assertEquals(1,adminService.createAdmin(adminListViewModel));
    }

    @Test
    void getAdminByName() {
        assertEquals(admin,adminService.getAdminByName(admin.getUsername_admin()));
    }

    @Test
    void checkIfAdminExists() {
        assertTrue(adminService.checkIfAdminExists(admin));
    }
}