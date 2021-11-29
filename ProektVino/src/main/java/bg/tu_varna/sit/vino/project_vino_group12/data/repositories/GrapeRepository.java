package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class GrapeRepository implements DAORepository<Grape> {
    private static final Logger log = Logger.getLogger(GrapeRepository.class);

    public static  GrapeRepository getInstance() {
        return GrapeRepository.GrapeRepositoryHolder.INSTANCE;
    }

    private static class GrapeRepositoryHolder {
        public static final  GrapeRepository INSTANCE = new GrapeRepository();
    }

    @Override
    public void save(Grape obj) {
        Session session= Connection.openSession();
        Transaction transaction= session.beginTransaction();
        try{
            session.save(obj);
            log.info("Grape saved successfully!");
        }catch(Exception e){
            log.error("Grape save error"+e.getMessage());
            e.printStackTrace();
        }finally {

            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(Grape obj) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.update(obj);
            log.info("Grape updated successfully!");
        }catch(Exception e) {
            log.error("Grape update error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(Grape obj) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Grape deleted successfully!");
        }catch(Exception e) {
            log.error("Grape delete error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public List<Grape> getById(Integer id) {

        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<Grape> grapes=new LinkedList<>();
        try{
            String jpql="SELECT g FROM Grape g WHERE id_sort ="+id;
            grapes.addAll(session.createQuery(jpql,Grape.class).getResultList());
            log.info("Get grape by id!");
        }catch(Exception e){
            log.error("Get grape error"+e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
        return grapes;
    }

    @Override
    public List<Grape> getAll() {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<Grape> grapes = new LinkedList<>();
        try{
            String jpql="SELECT g FROM Grape g";
            grapes.addAll(session.createQuery(jpql, Grape.class).getResultList());
            log.info("Get all grapes!");
        }catch(Exception e){
            log.error("Get grape error"+e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
        return grapes;
    }


}
