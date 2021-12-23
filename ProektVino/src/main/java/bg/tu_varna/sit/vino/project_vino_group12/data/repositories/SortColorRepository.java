package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.SortColor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.LinkedList;
import java.util.List;

public class SortColorRepository implements DAORepository<SortColor>{
    public static SortColorRepository getInstance() {
        return SortColorRepository.SortColorRepositoryHolder.INSTANCE;
    }

    private static class SortColorRepositoryHolder {
        public static final SortColorRepository INSTANCE = new SortColorRepository();
    }

    @Override
    public void save(SortColor obj) {
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
    public void update(SortColor obj) {
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
    public void delete(SortColor obj) {
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
    public SortColor getById(Integer id) {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        SortColor sortcolor=new SortColor();
        try{
            String jpql="SELECT s FROM Sort_color s WHERE id_sort_color ="+id;
            sortcolor=session.createQuery(jpql,SortColor.class).getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
        return sortcolor;
    }

    @Override
    public List<SortColor> getAll() {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<SortColor> sortColors = new LinkedList<>();
        try{
            String jpql="SELECT s FROM SortColor s";
            sortColors.addAll(session.createQuery(jpql, SortColor.class).getResultList());
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
        return sortColors;
    }
}
