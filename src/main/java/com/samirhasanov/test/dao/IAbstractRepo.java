/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.test.dao;

import java.util.List;

/**
 *
 * @author Hasanov (Asus)
 * @param <T>
 */
public interface IAbstractRepo<T> {
    public void save(T domain);
    public void delete(T domain) throws Exception;
    public void deleteById(Long domainId) throws Exception;
    public T findById(Long domainId);
    public List<T> getAll();
}
