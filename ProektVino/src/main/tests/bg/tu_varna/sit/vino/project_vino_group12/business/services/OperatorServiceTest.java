package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Operator;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.OperatorRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.OperatorListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OperatorServiceTest {
    private Operator operator;
    private OperatorService operatorService;
    private OperatorRepository operatorRepository;
    private OperatorListViewModel operatorListViewModel;

    @BeforeEach
    void setUp() {
        this.operatorRepository=OperatorRepository.getInstance();
        this.operatorService=OperatorService.getInstance();
        this.operator=new Operator("1","1");
        this.operatorListViewModel=new OperatorListViewModel("1","1");
        operatorRepository.delete(operator);
    }

    @Test
    void deleteOperator() {
        List<Operator> all=operatorRepository.getAll();
        operatorService.deleteOperator(operatorListViewModel);
        List<Operator> after=operatorRepository.getAll();
        assertNotEquals(all,after);
    }

    @Test
    void getAllOperators() {
        ObservableList<OperatorListViewModel> all= operatorService.getAllOperators();
        assertEquals(all,operatorService.getAllOperators());
    }

    @Test
    void operatorLogin() {
        assertTrue(operatorService.operatorLogin(operatorListViewModel));
    }

    @Test
    void createOperator() {
        assertEquals(1,operatorService.createOperator(operatorListViewModel));
    }

    @Test
    void getOperatorByName() {
        assertEquals(operator,operatorService.getOperatorByName(operatorListViewModel.getUsername_operator()));
    }

    @Test
    void checkIfOperatorExists() {
        assertTrue(operatorService.checkIfOperatorExists(operator));
    }
}