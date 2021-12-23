package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Grape;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.LinkedList;
import java.util.List;

public class GrapeRepository implements DAORepository<Grape> {
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
        }catch(Exception e){
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
        }catch(Exception e) {
            e.printStackTrace();
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
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public Grape getById(Integer id) {

        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        Grape grape=new Grape();
        try{
            String jpql="SELECT g FROM Grape g WHERE id_sort ="+id;
            grape=session.createQuery(jpql,Grape.class).getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
        return grape;
    }

    @Override
    public List<Grape> getAll() {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<Grape> grapes = new LinkedList<>();
        try{
            String jpql="SELECT g FROM Grape g";
            grapes.addAll(session.createQuery(jpql, Grape.class).getResultList());
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
        return grapes;
    }
}
