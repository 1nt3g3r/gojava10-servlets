package com.first.servlet.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateService {
    private SessionFactory sessionFactory;

    public HibernateService() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
