package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.WarehouseHost;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.LinkedList;
import java.util.List;

public class WarehouseHostRepository implements DAORepository<WarehouseHost> {
    public static WarehouseHostRepository getInstance() {
        return WarehouseHostRepository.WarehouseHostRepositoryHolder.INSTANCE;
    }

    private static class WarehouseHostRepositoryHolder {
        public static final WarehouseHostRepository INSTANCE = new WarehouseHostRepository();
    }

    @Override
    public void save(WarehouseHost obj) {
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
    public void update(WarehouseHost obj) {
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
    public void delete(WarehouseHost obj) {
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
    public WarehouseHost getById(Integer id) {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        WarehouseHost host=new WarehouseHost();
        try{
            String jpql="SELECT w FROM Domakin_sklad w WHERE id_domakin ="+id;
            host=session.createQuery(jpql,WarehouseHost.class).getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
        return host;
    }

    @Override
    public List<WarehouseHost> getAll() {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<WarehouseHost> warehouseHosts = new LinkedList<>();
        try{
            String jpql="SELECT wh FROM WarehouseHost wh";
            warehouseHosts.addAll(session.createQuery(jpql, WarehouseHost.class).getResultList());
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
        return warehouseHosts;
    }
}
