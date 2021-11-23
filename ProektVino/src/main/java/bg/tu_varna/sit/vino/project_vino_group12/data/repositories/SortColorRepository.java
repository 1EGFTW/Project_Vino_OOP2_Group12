package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Bottles;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.SortColor;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class SortColorRepository implements DAORepository<SortColor>{
    private static final Logger log = Logger.getLogger(SortColorRepository.class);

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
            log.info("SortColor saved successfully!");
        }catch(Exception e){
            log.error("SortColor save error"+e.getMessage());
            e.printStackTrace();
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void update(SortColor obj) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.update(obj);
            log.info("SortColor updated successfully!");
        }catch(Exception e) {
            log.error("SortColor update error" + e.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(SortColor obj) {
        Session session=Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.delete(obj);
            log.info("SortColor deleted successfully!");
        }catch(Exception e) {
            log.error("SortColor delete error" + e.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public List<SortColor> getById(Integer id) {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<SortColor> sortcolors=new LinkedList<>();
        try{
            String jpql="SELECT s FROM Sort_color s WHERE id_sort_color ="+id;
            sortcolors.addAll(session.createQuery(jpql,SortColor.class).getResultList());
            log.info("Get sortcolor by id!");
        }catch(Exception e){
            log.error("Get sortcolor error"+e.getMessage());
        }finally {
            transaction.commit();
        }
        return sortcolors;
    }

    @Override
    public List<SortColor> getAll() {
        Session session=Connection.openSession();
        Transaction transaction= session.beginTransaction();
        List<SortColor> sortColors = new LinkedList<>();
        try{
            String jpql="SELECT s FROM SortColor s";
            sortColors.addAll(session.createQuery(jpql, SortColor.class).getResultList());
            log.info("Get all sort colors!");
        }catch(Exception e){
            log.error("Get sort color error"+e.getMessage());
        }finally {
            transaction.commit();
        }
        return sortColors;
    }


}
