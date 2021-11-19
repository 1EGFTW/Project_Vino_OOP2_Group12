package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Operator;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OperatorRepository implements DAORepository<Operator>{
    private static final Logger log = Logger.getLogger(OperatorRepository.class);

    public static  OperatorRepository getInstance() {
        return OperatorRepository.OperatorRepositoryHolder.INSTANCE;
    }

    private static class OperatorRepositoryHolder {

        public static final OperatorRepository INSTANCE = new OperatorRepository();
    }

    @Override
    public void save(Operator obj) {
        Session session= Connection.openSession();
        Transaction transaction= session.beginTransaction();
        try{
            session.save(obj);
            log.info("Operator saved successfully!");
        }catch(Exception e){
            log.error("Operator save error"+e.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void update(Operator obj) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.update(obj);
            log.info("Operator updated successfully!");
        }catch(Exception e) {
            log.error("Operator update error" + e.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(Operator obj) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Operator deleted successfully!");
        }catch(Exception e) {
            log.error("Operator delete error" + e.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public List<Operator> getById(Integer id) {

        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<Operator> operators=new LinkedList<>();
        try{
            String jpql="SELECT o FROM Operator o WHERE id_operator ="+id;
            operators.addAll(session.createQuery(jpql,Operator.class).getResultList());
            log.info("Get operator by id!");
        }catch(Exception e){
            log.error("Get operator error"+e.getMessage());
        }finally {
            transaction.commit();
        }
        return operators;
    }

    @Override
    public List<Operator> getAll() {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<Operator> operators = new LinkedList<>();
        try{
            String jpql="SELECT o FROM Operator o";
            operators.addAll(session.createQuery(jpql, Operator.class).getResultList());
            log.info("Get all operators!");
        }catch(Exception e){
            log.error("Get operator error"+e.getMessage());
        }finally {
            transaction.commit();
        }
        return operators;
    }


}
