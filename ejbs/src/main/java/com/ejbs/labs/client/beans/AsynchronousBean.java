package com.ejbs.labs.client.beans;

import com.ejbs.labs.server.beans.async.AsynchronousSessionBeanRemote;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.Future;

@Named(value = "asynchronousBean")
@SessionScoped
public class AsynchronousBean implements Serializable {

    @EJB
    private AsynchronousSessionBeanRemote asynchronousSessionBeanRemote;

    public void getWithSlow(){
        System.out.println("######## getWithSlow ##########");
        asynchronousSessionBeanRemote.slowMethod();
    }
    public Future<Long> slowMethodWithReturnValue(){
        System.out.println("######## slowMethodWithReturnValue ##########");
        Future<Long> longFuture = asynchronousSessionBeanRemote.slowMethodWithReturnValue();
        System.out.println("######## LongFuture ######## " + longFuture.toString());
        return longFuture;
    }
}
