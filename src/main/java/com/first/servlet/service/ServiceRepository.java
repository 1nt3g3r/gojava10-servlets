package com.first.servlet.service;

import java.util.HashMap;
import java.util.Map;

public class ServiceRepository {
    private static final ServiceRepository INSTANCE = new ServiceRepository();
    private Map<Class, Object> services = new HashMap<Class, Object>();

    public static ServiceRepository getInstance() {
        return INSTANCE;
    }

    private ServiceRepository() {
        register(new QuoteService());
        register(new LanguageDetectService());
        register(new SecurityService());
        register(new HibernateService());
        register(new CrudRepositoryService());
    }

    private void register(Object service) {
        services.put(service.getClass(), service);
    }

    public <T> T getService(Class<T> tClass) {
        return (T) services.get(tClass);
    }
}
