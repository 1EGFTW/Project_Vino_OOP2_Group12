package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class WinesRepository implements DAORepository<Wines> {
    private static final Logger log = Logger.getLogger(WinesRepository.class);

    public static WinesRepository getInstance() {
        return WinesRepository.WinesRepositoryHolder.INSTANCE;
    }

    private static class WinesRepositoryHolder {
        public static final WinesRepository INSTANCE = new WinesRepository();
    }

    @Override
    public void save(Wines obj) {
        Session session= Connection.openSession();
        Transaction transaction= session.beginTransaction();
        try{
            session.save(obj);
            log.info("Wines saved successfully!");
        }catch(Exception e){
            log.error("Wines save error"+e.getMessage());
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(Wines obj) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.update(obj);
            log.info("Wines updated successfully!");
        }catch(Exception e) {
            log.error("Wines update error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(Wines obj) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Wines deleted successfully!");
        }catch(Exception e) {
            log.error("Wines delete error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public List<Wines> getById(Integer id) {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<Wines> wines=new LinkedList<>();
        try{
            String jpql="SELECT w FROM Wines w WHERE id_wine ="+id;
            wines.addAll(session.createQuery(jpql,Wines.class).getResultList());
            log.info("Get wine by id!");
        }catch(Exception e){
            log.error("Get wine error"+e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
        return wines;
    }

    @Override
    public List<Wines> getAll() {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<Wines> wines = new LinkedList<>();
        try{
            String jpql="SELECT w FROM Wines w";
            wines.addAll(session.createQuery(jpql, Wines.class).getResultList());
            log.info("Get all wines!");
        }catch(Exception e){
            log.error("Get wines error"+e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
        return wines;
    }


}
