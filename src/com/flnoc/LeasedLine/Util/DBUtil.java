package com.flnoc.LeasedLine.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by Rokhdelar on 2014-11-14.
 */
public class DBUtil {
    private static final DBUtil instance=new DBUtil();
    private SessionFactory sessionFactory;

    private DBUtil(){
        Configuration configuration=new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory=configuration.buildSessionFactory(serviceRegistry);
    }

    public static DBUtil getInstance(){
        return instance;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }

}
