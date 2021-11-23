package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Admin;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class AdminRepository implements DAORepository<Admin>{
    private static final Logger log=Logger.getLogger(AdminRepository.class);

    public static AdminRepository getInstance(){
        return AdminRepository.AdminRepositoryHolder.INSTANCE;
    }
    private static class AdminRepositoryHolder {
        public static final AdminRepository INSTANCE = new AdminRepository();
    }

    @Override
    public void save(Admin obj) {
        Session session= Connection.openSession();
        Transaction transaction= session.beginTransaction();
        try{
            session.save(obj);
            log.info("Admin saved successfully!");
        }catch(Exception e){
            log.error("Admin save error"+e.getMessage());
            e.printStackTrace();
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void update(Admin obj) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.update(obj);
            log.info("Admin updated successfully!");
        }catch(Exception e) {
            log.error("Admin update error" + e.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(Admin obj) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.delete(obj);
            log.info("Admin deleted successfully!");
        }catch(Exception e) {
            log.error("Admin delete error" + e.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public List<Admin> getById(Integer id) {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<Admin> admins=new LinkedList<>();
        try{
            String jpql="SELECT a FROM Admin a WHERE id_admin ="+id.toString();
            admins.addAll(session.createQuery(jpql,Admin.class).getResultList());
            log.info("Get all admins!");
        }catch(Exception e){
            log.error("Get admin error"+e.getMessage());
        }finally {
            transaction.commit();
        }
        return admins;
    }

   @Override
   public List<Admin> getAll() {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<Admin> admins=new LinkedList<>();
        try{
            String jpql="SELECT a FROM Admin a";
            admins.addAll(session.createQuery(jpql,Admin.class).getResultList());
            log.info("Get all admins!");
        }catch(Exception e){
            log.error("Get admin error"+e.getMessage());
        }finally {
            transaction.commit();
        }
        return admins;
    }


}
