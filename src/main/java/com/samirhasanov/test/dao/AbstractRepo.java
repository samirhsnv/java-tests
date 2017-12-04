/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.test.dao;

import com.samirhasanov.test.domain.AbstractDomain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hasanov (Asus)
 * @param <T>
 */
public class AbstractRepo<T extends AbstractDomain> implements IAbstractRepo<T>{
    protected Map<Long, T> records = new HashMap<>();
    
    @Override
    public void save(T domain) {
        if(domain.getId() == null) {
            Long id = (long) records.size() + 1;
            domain.setId(id);
        }
        
        records.put(domain.getId(), domain);
    }

    @Override
    public void delete(T domain) throws Exception{
        if(!records.containsKey(domain.getId())) {
            throw new Exception("Not found in records. Domain: " + domain + ", Id: " + domain.getId());
        }
        
        records.remove(domain.getId());
    }

    @Override
    public void deleteById(Long domainId) throws Exception {
        if(!records.containsKey(domainId)) {
            throw new Exception("Not found in records. Id: " + domainId);
        }
        
        records.remove(domainId);
    }

    @Override
    public T findById(Long domainId) {
        return records.get(domainId);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(records.values());
    }
    
}
