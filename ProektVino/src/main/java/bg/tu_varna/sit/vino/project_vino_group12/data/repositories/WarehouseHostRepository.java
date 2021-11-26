package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.WarehouseHost;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class WarehouseHostRepository implements DAORepository<WarehouseHost> {
    private static final Logger log = Logger.getLogger(WarehouseHost.class);

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
            log.info("WarehouseHost saved successfully!");
        }catch(Exception e){
            log.error("WarehouseHost save error"+e.getMessage());
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
            log.info("WarehouseHost updated successfully!");
        }catch(Exception e) {
            log.error("WarehouseHost update error" + e.getMessage());
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
            log.info("WarehouseHost deleted successfully!");
        }catch(Exception e) {
            log.error("WarehouseHost delete error" + e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public List<WarehouseHost> getById(Integer id) {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<WarehouseHost> hosts=new LinkedList<>();
        try{
            String jpql="SELECT w FROM Domakin_sklad w WHERE id_domakin ="+id;
            hosts.addAll(session.createQuery(jpql,WarehouseHost.class).getResultList());
            log.info("Get host by id!");
        }catch(Exception e){
            log.error("Get warehouseHost error"+e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
        return hosts;
    }

    @Override
    public List<WarehouseHost> getAll() {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<WarehouseHost> warehouseHosts = new LinkedList<>();
        try{
            String jpql="SELECT wh FROM WarehouseHost wh";
            warehouseHosts.addAll(session.createQuery(jpql, WarehouseHost.class).getResultList());
            log.info("Get all warehouse hosts!");
        }catch(Exception e){
            log.error("Get warehouse host error"+e.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
        return warehouseHosts;
    }
}
