package com.uniyaz.springboot.utility.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HelperFactory {

    private static final SessionFactory sessionFactory = buildFactory();

    private static SessionFactory buildFactory() {

        SessionFactory sessionFactory = null;
        try {
            Configuration configuration = new Configuration();
            sessionFactory = configuration.configure().buildSessionFactory();
            return sessionFactory;
        } catch (Exception e) {
            System.out.println("Session Oluşturulamadı.");
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
