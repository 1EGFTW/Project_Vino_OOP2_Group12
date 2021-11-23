package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Production;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ProductionRepository implements DAORepository<Production> {
    private static final Logger log = Logger.getLogger(ProductionRepository.class);

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
            log.info("Production saved successfully!");
        }catch(Exception e){
            log.error("Production save error"+e.getMessage());
            e.printStackTrace();
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void update(Production obj) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.update(obj);
            log.info("Production updated successfully!");
        }catch(Exception e) {
            log.error("Production update error" + e.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(Production obj) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Production deleted successfully!");
        }catch(Exception e) {
            log.error("Production delete error" + e.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public List<Production> getById(Integer id)
    {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<Production> productions=new LinkedList<>();
        try{
            String jpql="SELECT p FROM Production p WHERE id_production ="+id;
            productions.addAll(session.createQuery(jpql,Production.class).getResultList());
            log.info("Get production by id!");
        }catch(Exception e){
            log.error("Get admin error"+e.getMessage());
        }finally {
            transaction.commit();
        }
        return productions;
    }

    @Override
    public List<Production> getAll() {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<Production> productions = new LinkedList<>();
        try{
            String jpql="SELECT p FROM Production p";
            productions.addAll(session.createQuery(jpql, Production.class).getResultList());
            log.info("Get all productions!");
        }catch(Exception e){
            log.error("Get production error"+e.getMessage());
        }finally {
            transaction.commit();
        }
        return productions;
    }


}
