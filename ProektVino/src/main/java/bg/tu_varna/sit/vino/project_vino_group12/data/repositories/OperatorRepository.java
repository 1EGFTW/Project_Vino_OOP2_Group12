package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Operator;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.LinkedList;
import java.util.List;

public class OperatorRepository implements DAORepository<Operator>{
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
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(Operator obj) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.update(obj);
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(Operator obj) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.delete(obj);
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public Operator getById(Integer id) {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        Operator operator=new Operator();
        try{
            String jpql="SELECT o FROM Operator o WHERE id_operator ="+id;
            operator=session.createQuery(jpql,Operator.class).getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
        return operator;
    }

    @Override
    public List<Operator> getAll() {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<Operator> operators = new LinkedList<>();
        try{
            String jpql="SELECT o FROM Operator o";
            operators.addAll(session.createQuery(jpql, Operator.class).getResultList());
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
        return operators;
    }
}
