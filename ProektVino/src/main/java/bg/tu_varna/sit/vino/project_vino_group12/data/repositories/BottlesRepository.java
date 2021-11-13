package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.BottlesService;
import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class BottlesRepository implements DAORepository<Bottles>{
    private static final Logger log = Logger.getLogger(BottlesRepository.class);

    public static BottlesRepository getInstance() {
        return BottlesRepository.BottlesRepositoryHolder.INSTANCE;
    }
    public static class BottlesRepositoryHolder {
        public static final BottlesRepository INSTANCE = new BottlesRepository();
    }

    @Override
    public void save(Bottles obj) {
        Session session = Connection.openSession();
        Transaction transaction= session.beginTransaction();
        try{
            session.save(obj);
            log.info("Bottle saved successfully!");
        }catch(Exception e){
            log.error("Bottle save error"+e.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void update(Bottles obj) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.update(obj);
            log.info("Bottle updated successfully!");
        }catch(Exception e) {
            log.error("Bottle update error" + e.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(Bottles obj) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Bottle deleted successfully!");
        }catch(Exception e) {
            log.error("Bottle delete error" + e.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public Optional<Bottles> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Bottles> getAll() {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<Bottles> bottles = new LinkedList<>();
        try{
            String jpql="SELECT b FROM Bottles b";
            bottles.addAll(session.createQuery(jpql,Bottles.class).getResultList());
            log.info("Get all bottles!");
        }
        catch (Exception e){
            log.error("Get bottles error" + e.getMessage());
        }
        finally {
            transaction.commit();
        }
        return bottles;
    }


}
