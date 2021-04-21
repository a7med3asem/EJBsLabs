package com.ejbs.labs.server.beans.timer;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;

@Singleton
public class ProgTimer {
   public int scheduleTime = 0;
    @Resource
    private TimerService timerService;

    @Timeout
    public void timeOut() {
        scheduleTime += 4;
        System.out.println("############# ProgTimer Method Invoked ##################");
    }


    @PostConstruct
    public void initTimer() {
        System.out.println("############# INIT-CALLED #############");
        ScheduleExpression exp = new ScheduleExpression();
        exp.hour("*").minute("*").second("*/4");
        timerService.createCalendarTimer(exp);
    }

    public void displayTimer() {
        System.out.println("############ Timer Invoke ############# ");
    }
}


