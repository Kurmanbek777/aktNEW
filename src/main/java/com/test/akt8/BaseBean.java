/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.akt8;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author kbakytbekov
 */
public abstract class BaseBean implements Serializable{
    @PersistenceContext(unitName = "com.test_akt8_war_1.0PU")
    private EntityManager em;
    
    @Resource
    protected UserTransaction userTransaction;
    
    protected EntityManager getEntityManager(){
        return em;
    }
    
    public void init(){
        
    }
    
    public void add(){
        
    }
    
    public void delete(){
        
    }
    
    public void save(){
        
    }
    
    public void edit(RowEditEvent event){
        
    }
    
    public void search(){
        
    }
    
    public void cancel(){
        
    }
}
