package com.ejbs.labs.server.beans.timer;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class AutomaticTimer {

    @Schedule(hour="*", minute="*", second="*/4")
    public void timeOut() {
        System.out.println("############# Timer Method Invoked ##################");
    }

}
