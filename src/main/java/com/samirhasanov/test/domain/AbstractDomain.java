/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.test.domain;

/**
 *
 * @author Hasanov (Asus)
 */
public abstract class AbstractDomain {
    private Long id;

    public AbstractDomain() {
    }

    public AbstractDomain(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AbstractDomain{" + "id=" + id + '}';
    }
}
