package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import static org.junit.jupiter.api.Assertions.*;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Admin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdminRepositoryTest {
    private Admin admin;
    private AdminRepository adminRepository;

    @BeforeEach
    void setUp() {
        this.adminRepository=AdminRepository.getInstance();
        this.admin=new Admin("222","222");
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
        admin.setUsername_admin("333");
        admin.setPassword_admin("333");
        adminRepository.update(admin);
        assertNotEquals(all,adminRepository.getAll());
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