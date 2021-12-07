package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminListViewModelTest {

    private AdminListViewModel adminListViewModel;
    private AdminListViewModel adminListViewModel1;
    @BeforeEach
    void setUp() {
        adminListViewModel=new AdminListViewModel();
        adminListViewModel.setPassword_admin("Admin");
        adminListViewModel.setUsername_admin("Admin");
        adminListViewModel1=new AdminListViewModel();
        adminListViewModel1.setPassword_admin("Admin");
        adminListViewModel1.setUsername_admin("Admin");
    }

    @Test
    void testEquals() {
        assertTrue(adminListViewModel.equals(adminListViewModel1));
    }

    @Test
    void getUsername_admin() {
        assertEquals("Admin",adminListViewModel.getUsername_admin());
    }

    @Test
    void getPassword_admin() {
        assertEquals("Admin",adminListViewModel.getPassword_admin());
    }
}