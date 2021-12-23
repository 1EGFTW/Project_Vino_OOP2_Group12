package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Production;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.LinkedList;
import java.util.List;

public class ProductionRepository implements DAORepository<Production> {
    public static ProductionRepository getInstance() {
        return ProductionRepository.ProductionRepositoryHolder.INSTANCE;
    }

    private static class ProductionRepositoryHolder {
        public static final ProductionRepository INSTANCE = new ProductionRepository();
    }

    @Override
    public void save(Production obj) {
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
    public void update(Production obj) {
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
    public void delete(Production obj) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.delete(obj);
            session.flush();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public Production getById(Integer id)
    {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        Production production=new Production();
        try{
            String jpql="SELECT p FROM Production p WHERE id_production="+id;
            production=session.createQuery(jpql,Production.class).getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
        return production;
    }

    @Override
    public List<Production> getAll() {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<Production> productions = new LinkedList<>();
        try{
            String jpql="SELECT p FROM Production p";
            productions.addAll(session.createQuery(jpql, Production.class).getResultList());
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
        return productions;
    }
}
