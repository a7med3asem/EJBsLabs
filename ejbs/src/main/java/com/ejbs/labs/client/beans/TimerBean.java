package com.ejbs.labs.client.beans;

import com.ejbs.labs.server.beans.timer.ProgTimer;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "timerBean")
@SessionScoped
public class TimerBean implements Serializable {

    @EJB
    private ProgTimer progTimer;

    public TimerBean() {
        progTimer.displayTimer();
        System.out.println("########### Timer ############");
    }
}
