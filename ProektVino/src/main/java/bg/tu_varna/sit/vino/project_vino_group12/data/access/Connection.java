package bg.tu_varna.sit.vino.project_vino_group12.data.access;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {
    private static final Logger log=Logger.getLogger(Connection.class);
    private static SessionFactory sessionFactory;
    static{
        try{
            sessionFactory=new Configuration().buildSessionFactory();
        }catch (Throwable e)
        {
            log.error("Initial SessionFactory error"+e);
        }
    }
    public static Session openSession(){
        return sessionFactory.openSession();
    }
    public static void closeSession(){
        sessionFactory.close();
    }
}
