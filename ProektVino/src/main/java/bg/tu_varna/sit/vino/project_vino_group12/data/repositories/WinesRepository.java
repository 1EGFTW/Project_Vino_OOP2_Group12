package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Wines;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.LinkedList;
import java.util.List;

public class WinesRepository implements DAORepository<Wines> {
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
        }catch(Exception e){
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
        }catch(Exception e) {
            e.printStackTrace();
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
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public Wines getById(Integer id) {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        Wines wine=new Wines();
        try{
            String jpql="SELECT w FROM Wines w WHERE id_wine ="+id;
            wine=session.createQuery(jpql,Wines.class).getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
        return wine;
    }

    @Override
    public List<Wines> getAll() {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<Wines> wines = new LinkedList<>();
        try{
            String jpql="SELECT w FROM Wines w";
            wines.addAll(session.createQuery(jpql, Wines.class).getResultList());
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
        return wines;
    }


}
