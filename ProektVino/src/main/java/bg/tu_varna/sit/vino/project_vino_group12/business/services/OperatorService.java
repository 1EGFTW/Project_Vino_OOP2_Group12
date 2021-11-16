package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Operator;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.OperatorRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.OperatorListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class OperatorService {
    private final OperatorRepository repository = OperatorRepository.getInstance();
    public static OperatorService getInstance() {
        return OperatorServiceHolder.INSTANCE;
    }
    private static final Logger log = Logger.getLogger(OperatorRepository.class);
    private static class OperatorServiceHolder {
        public static final OperatorService INSTANCE = new OperatorService();
    }

    public ObservableList<OperatorListViewModel> getAllOperators() {
        List<Operator> operators = repository.getAll();

        return FXCollections.observableList(
                operators.stream().map(o -> new OperatorListViewModel(
                        o.getUsername_operator(),
                        o.getPassword_operator()
                )).collect(Collectors.toList()));
    }

   /* public void insertOperators() // dobavqne na operatori ot admin prez fxml
    {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.save(o);
            log.info("Operator inserted successfully!");
        }catch(Exception e) {
            log.error("Operator insert error" + e.getMessage());
        }finally {
            transaction.commit();
        }
    }
    */
}
