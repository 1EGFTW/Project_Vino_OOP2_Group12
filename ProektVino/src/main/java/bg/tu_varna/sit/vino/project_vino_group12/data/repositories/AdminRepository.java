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
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void update(Admin obj) {

    }

    @Override
    public void delete(Admin obj) {

    }

    @Override
    public Optional<Admin> getById(Integer id) {
        return Optional.empty();
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
