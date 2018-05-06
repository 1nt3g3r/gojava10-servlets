package com.first.servlet.service;

import com.first.servlet.repository.CrudRepository;

import java.util.HashMap;
import java.util.Map;

public class CrudRepositoryService {
    private Map<Class<? extends Object>, CrudRepository> cache = new HashMap<Class<? extends Object>, CrudRepository>();

    public <T, K> CrudRepository<T, K> getRepository(Class<T> tClass) {
        if (cache.containsKey(tClass)) {
            return cache.get(tClass);
        }

        CrudRepository<T, K> result = new CrudRepository<T, K>(tClass);
        cache.put(tClass, result);
        return result;
    }
}
