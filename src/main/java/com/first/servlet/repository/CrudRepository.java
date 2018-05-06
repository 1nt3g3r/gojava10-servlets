package com.first.servlet.repository;

import com.first.servlet.service.HibernateService;
import com.first.servlet.service.ServiceRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CrudRepository<T, K> {
    private Class<T> tClass;
    private SessionFactory sessionFactory;

    public CrudRepository(Class tClass) {
        this.tClass = tClass;

        HibernateService hibernateService = ServiceRepository.getInstance().getService(HibernateService.class);
        sessionFactory = hibernateService.getSessionFactory();
    }

    public void create(T object) {
        Session session = openTransactSession();
        session.save(object);
        closeTransactSession(session);
    };

    public T getById(K id) {
        T result = null;
        Session session = openSession();
        result = session.get(tClass, (Serializable) id);
        session.close();
        return result;
    }

    public void update(T object) {
        Session session = openTransactSession();
        session.update(object);
        closeTransactSession(session);
    }

    public void delete(T object) {
        Session session = openTransactSession();
        session.delete(object);
        closeTransactSession(session);
    }

    public void deleteById(K id) {
        Session session = openTransactSession();
        session.delete(getById(id));
        closeTransactSession(session);
    }

    public List<T> listAll() {
        List<T> result = new ArrayList<T>();

        String entityName = tClass.getSimpleName();
        String hql = "from " + entityName;

        Session session = openSession();
        result = session.createQuery(hql, tClass).list();
        session.close();

        return result;
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    public Session openTransactSession() {
        Session session = openSession();
        session.beginTransaction();
        return session;
    }

    public void closeTransactSession(Session session) {
        session.getTransaction().commit();
        session.close();
    }
}
