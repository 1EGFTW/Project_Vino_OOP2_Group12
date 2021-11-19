package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Operator;
import bg.tu_varna.sit.vino.project_vino_group12.data.repositories.OperatorRepository;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.AdminListViewModel;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.OperatorListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.stream.Collectors;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.ADMIN_VIEW;
import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.OPERATOR_VIEW;

public class OperatorService {
    public boolean logIn=false;
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
   public void operatorLogin(OperatorListViewModel o)
   {
       ObservableList<OperatorListViewModel> allOperators= getAllOperators();
       for (OperatorListViewModel operator:allOperators)
       {
           if(operator.equals(o))
           {
               logIn=true;
           }
       }
       if(logIn)
       {
           try {
               FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(OPERATOR_VIEW));
               Parent root1 = (Parent) fxmlLoader.load();
               Stage stage = new Stage();
               stage.setScene(new Scene(root1));
               stage.show();
           } catch(Exception e) {
               e.printStackTrace();
           }
       }
   }
}
