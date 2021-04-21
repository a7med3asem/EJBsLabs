/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejbs.labs.server.beans.hits;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import static javax.ejb.LockType.WRITE;


@Singleton
@LocalBean
public class CounterBean {

    private int hits = 1;
    
    @Lock(WRITE)
    public int getHits(){
        return hits++;
    }
    
    @PostConstruct
    public void postConstruct(){
        System.out.println("from post Construct");
    }
    
    @PreDestroy
    public void preDestroy(){
        System.out.println("from pre destroy");
    }
}
