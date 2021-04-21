package com.ejbs.labs.server.beans.async;

import javax.ejb.Remote;
import java.util.concurrent.Future;

@Remote
public interface AsynchronousSessionBeanRemote {
    public void slowMethod();

    public Future<Long> slowMethodWithReturnValue();
}
