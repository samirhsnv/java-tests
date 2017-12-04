/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.test.service;

import com.samirhasanov.test.domain.User;
import java.util.List;

/**
 *
 * @author Hasanov (Asus)
 */
public interface IUserService {
    public void save(User user);
    public void delete(User user) throws Exception;
    public void deleteById(Long userId) throws Exception;
    public User findById(Long userId);
    public List<User> getAll();
}
