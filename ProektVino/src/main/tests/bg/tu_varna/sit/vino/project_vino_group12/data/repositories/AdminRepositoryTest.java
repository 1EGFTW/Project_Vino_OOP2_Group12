package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import static org.junit.jupiter.api.Assertions.*;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.AdminService;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Admin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class AdminRepositoryTest {
    private Admin admin;
    private AdminRepository adminRepository;
    private AdminService adminService;
    @BeforeEach
    void setUp() {
        this.adminRepository=AdminRepository.getInstance();
        this.adminService=AdminService.getInstance();
        this.admin=new Admin();
    }

    @Test
    void save() {
        List<Admin> all=adminRepository.getAll();
        adminRepository.save(admin);
        assertNotEquals(all,adminRepository.getAll());
    }

    @Test
    void update() {
        List<Admin> all=adminRepository.getAll();
        Admin a=adminRepository.getById(2);
        a.setUsername_admin("2");
        a.setPassword_admin("2");
        adminRepository.update(a);
        assertEquals(all,adminRepository.getAll());
    }

    @Test
    void delete() {
        List<Admin> all=adminRepository.getAll();
        adminRepository.delete(admin);
        assertEquals(all,adminRepository.getAll());
    }


    @Test
    void getAll() {
        List<Admin> all=adminRepository.getAll();
        List<Admin> newList=adminRepository.getAll();
        assertEquals(all,newList);
    }
}