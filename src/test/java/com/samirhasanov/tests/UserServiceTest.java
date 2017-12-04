/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.tests;

import com.samirhasanov.test.service.UserService;
import com.samirhasanov.test.dao.AbstractRepo;
import com.samirhasanov.test.domain.User;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hasanov (Asus)
 */
public class UserServiceTest {
    private final AbstractRepo<User> userRepo = new AbstractRepo<>();
    private UserService userService;
    
    public UserServiceTest() {
    }
    
    @Before
    public void setUp() {
        userRepo.save(new User("Samir Hasanov", 28));
        userRepo.save(new User("Murad Rzayev", 27));
        
        userService = new UserService(userRepo);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class UserService.
     */
    @Test
    public void testSave() {
        User user = new User("Ziya Akbarli", 27);
        userService.save(user);
        
        Long userId = 3L;
        User addedUser = userService.findById(userId);
        assertNotNull(addedUser);
    }

    /**
     * Test of delete method, of class UserService.
     */
    @Test
    public void testDeletePositive() throws Exception {
        User user = new User("", 0, 1L);
        userService.delete(user);
        
        User removedUser = userService.findById(1L);
        assertNull(removedUser);
        
        List<User> list = userService.getAll();
        assertEquals(1, list.size());
    }
    
    @Test(expected = Exception.class)
    public void testDeleteNegative() throws Exception {
        User user = new User("", 0, 99L);
        userService.delete(user);
    }

    /**
     * Test of deleteById method, of class UserService.
     */
    @Test
    public void testDeleteByIdPositive() throws Exception {
        Long userId = 1L;
        userService.deleteById(userId);
        
        User user = userService.findById(userId);
        assertNull(user);
        
        List<User> list = userService.getAll();
        assertEquals(1, list.size());
    }
    
    @Test(expected = Exception.class)
    public void testDeleteByIdNegative() throws Exception {
        userService.deleteById(99L);
    }

    /**
     * Test of findById method, of class UserService.
     */
    @Test
    public void testFindById() {
        User result = userService.findById(1L);
        assertNotNull(result);
        
        User nullUser = userService.findById(99L);
        assertNull(nullUser);
    }

    /**
     * Test of getAll method, of class UserService.
     */
    @Test
    public void testGetAll() {
        List<User> result = userService.getAll();
        assertEquals(2, result.size());
    }
    
}
