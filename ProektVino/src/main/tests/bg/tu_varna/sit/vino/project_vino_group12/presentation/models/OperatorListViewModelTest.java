package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorListViewModelTest {
    private OperatorListViewModel operatorListViewModel;
    private OperatorListViewModel operatorListViewModel1;

    @BeforeEach
    void setUp() {
        operatorListViewModel=new OperatorListViewModel("operator","operator");
        operatorListViewModel1=new OperatorListViewModel("operator1","operator");
    }

    @Test
    void testEquals() {
        assertFalse(operatorListViewModel.equals(operatorListViewModel1));
    }

    @Test
    void getUsername_operator() {
        assertEquals("operator",operatorListViewModel.getUsername_operator());
        assertEquals("operator1",operatorListViewModel1.getUsername_operator());
    }

    @Test
    void getPassword_operator() {
        assertEquals("operator",operatorListViewModel.getPassword_operator());
        assertEquals("operator",operatorListViewModel1.getPassword_operator());
    }
}