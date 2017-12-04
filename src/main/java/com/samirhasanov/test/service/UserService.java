/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.test.service;

import com.samirhasanov.test.dao.AbstractRepo;
import com.samirhasanov.test.domain.User;
import java.util.List;

/**
 *
 * @author Hasanov (Asus)
 */
public class UserService implements IUserService {
    private final AbstractRepo<User> userRepo;
    
    public UserService(AbstractRepo<User> userRepo) {
        this.userRepo = userRepo;
    }
    
    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void delete(User user) throws Exception {
        userRepo.delete(user);
    }

    @Override
    public void deleteById(Long userId) throws Exception {
        userRepo.deleteById(userId);
    }

    @Override
    public User findById(Long userId) {
        return userRepo.findById(userId);
    }

    @Override
    public List<User> getAll() {
        return userRepo.getAll();
    }
    
}
