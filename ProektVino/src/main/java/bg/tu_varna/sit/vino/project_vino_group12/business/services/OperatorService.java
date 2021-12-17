package bg.tu_varna.sit.vino.project_vino_group12.business.services;

import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Admin;
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
    private final OperatorRepository repository = OperatorRepository.getInstance();
    public static OperatorService getInstance() {
        return OperatorServiceHolder.INSTANCE;
    }
    private static final Logger log = Logger.getLogger(OperatorService.class);
    private static class OperatorServiceHolder {
        public static final OperatorService INSTANCE = new OperatorService();
    }

    public void deleteOperator(OperatorListViewModel operator) {
        Operator o=getOperatorByName(operator.getUsername_operator());
        try{
            repository.delete(o);
            log.info("Successfully deleted operator: "+o);
        }
        catch (Exception e){
            e.printStackTrace();
            log.error("Error deleting operator: "+o);
        }
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
   public boolean operatorLogin(OperatorListViewModel o)
   {
       if(getOperatorByName(o.getUsername_operator())==null){
           log.error("Operator login error!");
           return false;
       }
       log.info("Operator login successful!");
       return true;

   }
    public int createOperator(OperatorListViewModel o){
       Operator operator=new Operator(o.getUsername_operator(),o.getPassword_operator());
       if(checkIfOperatorExists(operator)){
           return 0;
       }else{
           try{
               repository.save(operator);
               log.info("Successfully created operator: "+operator.getUsername_operator());
           }
           catch (Exception e) {
               e.printStackTrace();
               log.error("Error creating operator!");
           }
           return 1;
       }
    }
    public Operator getOperatorByName(String name){
       List<Operator> allOperators=repository.getAll();
       for(Operator o:allOperators){
           if(o.getUsername_operator().equals(name)){
               return o;
           }
       }
        log.error("Operator not found!");
       return null;
    }
    public boolean checkIfOperatorExists(Operator o){
       List<Operator> allOperators=repository.getAll();
       for(Operator operator:allOperators){
           if(operator.equals(o)){
               return true;
           }
       }
        log.error("No such operator!");
       return false;
    }
}
