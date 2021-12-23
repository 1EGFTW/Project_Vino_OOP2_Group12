package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.LinkedList;
import java.util.List;

public class BottlesRepository implements DAORepository<Bottles>{
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
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(Bottles obj) {
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
    public void delete(Bottles obj) {
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
    public Bottles getById(Integer id) {

        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        Bottles bottle=new Bottles();
        try{
            String jpql="SELECT b FROM Bottles b WHERE id_bottle ="+id;
            bottle=session.createQuery(jpql,Bottles.class).getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
        return bottle;
    }

    @Override
    public List<Bottles> getAll() {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<Bottles> bottles = new LinkedList<>();
        try{
            String jpql="SELECT b FROM Bottles b";
            bottles.addAll(session.createQuery(jpql,Bottles.class).getResultList());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return bottles;
    }
}
