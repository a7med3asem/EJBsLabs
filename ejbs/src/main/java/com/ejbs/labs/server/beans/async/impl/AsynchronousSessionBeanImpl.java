package com.ejbs.labs.server.beans.async.impl;

import com.ejbs.labs.server.beans.async.AsynchronousSessionBeanRemote;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class AsynchronousSessionBeanImpl implements AsynchronousSessionBeanRemote {

    private static Logger logger = Logger.getLogger(
            AsynchronousSessionBeanImpl.class.getName());


    @Asynchronous
    @Override
    public void slowMethod() {
        long startTime = System.currentTimeMillis();
        logger.info("####### entering " + this.getClass().getCanonicalName()
                + ".slowMethod()");
        try {
            Thread.sleep(4000); //simulate processing for 10 seconds
        } catch (InterruptedException ex) {
            Logger.getLogger(AsynchronousSessionBeanImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        logger.info("leaving " + this.getClass().getCanonicalName()
                + ".slowMethod()");
        long endTime = System.currentTimeMillis();
        logger.info("execution took " + (endTime - startTime)
                + " milliseconds");
    }


    @Asynchronous
    @Override
    public Future<Long> slowMethodWithReturnValue() {
        System.out.println("########## From Future #######");
        try {
            Thread.sleep(4000); //simulate processing for 15 seconds
        } catch (InterruptedException ex) {
            Logger.getLogger(AsynchronousSessionBeanImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return new AsyncResult<Long>(42L);
    }

}
