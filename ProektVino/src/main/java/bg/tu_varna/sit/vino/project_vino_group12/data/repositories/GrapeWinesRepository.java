package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.GrapeWines;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class GrapeWinesRepository implements DAORepository<GrapeWines>{
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
        } catch (Exception e) {
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
        } catch (Exception e) {
            e.printStackTrace();
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public GrapeWines getById(Integer id) {

        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        GrapeWines grape = new GrapeWines();
        try {
            String jpql = "SELECT g FROM GrapeWines g WHERE id_sort_wine =" + id;
            grape=session.createQuery(jpql, GrapeWines.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return grape;
    }

    @Override
    public List<GrapeWines> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<GrapeWines> grapes = new LinkedList<>();
        try {
            String jpql = "SELECT g FROM GrapeWines g";
            grapes.addAll(session.createQuery(jpql, GrapeWines.class).getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return grapes;
    }
}
