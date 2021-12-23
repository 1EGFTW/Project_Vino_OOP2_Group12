package bg.tu_varna.sit.vino.project_vino_group12.data.repositories;

import bg.tu_varna.sit.vino.project_vino_group12.data.access.Connection;
import bg.tu_varna.sit.vino.project_vino_group12.data.entities.Admin;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class AdminRepository implements DAORepository<Admin> {
    public static AdminRepository getInstance() {
        return AdminRepository.AdminRepositoryHolder.INSTANCE;
    }

    private static class AdminRepositoryHolder {
        public static final AdminRepository INSTANCE = new AdminRepository();
    }

    @Override
    public void save(Admin obj) {
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
    public void update(Admin obj) {
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
    public void delete(Admin obj) {
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
    public Admin getById(Integer id) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        Admin admin = new Admin();
        try {
            String jpql = "SELECT a FROM Admin a WHERE id_admin =" + id.toString();
            admin=session.createQuery(jpql, Admin.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return admin;
    }

    @Override
    public List<Admin> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Admin> admins = new LinkedList<>();
        try {
            String jpql = "SELECT a FROM Admin a";
            admins.addAll(session.createQuery(jpql, Admin.class).getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
        return admins;
    }
}
