package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.GrapeWines;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class GrapeWinesRepository implements DAORepository<GrapeWines>{
    private static final Logger log = Logger.getLogger(bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeWinesRepository.class);

    public static bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeWinesRepository getInstance() {
        return bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeWinesRepository.GrapeWinesRepositoryHolder.INSTANCE;
    }

    private static class GrapeWinesRepositoryHolder {
        public static final bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeWinesRepository INSTANCE = new bg.tu_varna.sit.vino.project_vino_group12.data.repositories.GrapeWinesRepository();
    }

    @Override
    public void save(GrapeWines obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(obj);
           /* log.info("GrapeWines saved successfully!");*/
        } catch (Exception e) {
            /*log.error("GrapeWines save error" + e.getMessage());*/
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(GrapeWines obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(obj);
           /* log.info("GrapeWines updated successfully!");*/
        } catch (Exception e) {
            /*log.error("GrapeWines update error" + e.getMessage());*/
        } finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(GrapeWines obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj);
            /*log.info("GrapeWines deleted successfully!");*/
        } catch (Exception e) {
            /*log.error("GrapeWines delete error" + e.getMessage());*/
        } finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public List<GrapeWines> getById(Integer id) {

        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<GrapeWines> grapes = new LinkedList<>();
        try {
            String jpql = "SELECT g FROM GrapeWines g WHERE id_sort_wine =" + id;
            grapes.addAll(session.createQuery(jpql, GrapeWines.class).getResultList());
            /*log.info("Get grapeWines by id!");*/
        } catch (Exception e) {
        /*    log.error("Get grapeWines error" + e.getMessage());*/
        } finally {
            transaction.commit();
            session.close();
        }
        return grapes;
    }

    @Override
    public List<GrapeWines> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<GrapeWines> grapes = new LinkedList<>();
        try {
            String jpql = "SELECT g FROM GrapeWines g";
            grapes.addAll(session.createQuery(jpql, GrapeWines.class).getResultList());
            /*log.info("Get all grapesWines!");*/
        } catch (Exception e) {
           /* log.error("Get grapeWines error" + e.getMessage());*/
        } finally {
            transaction.commit();
            session.close();
        }
        return grapes;
    }

}
