package com.ejbs.labs.client.beans;


import com.ejbs.labs.server.beans.hits.CounterBean;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named(value = "indexManagedBean")
@ApplicationScoped
public class HitsManagedBean {

    @EJB
    private CounterBean counterBean;

    private int hits;

    public HitsManagedBean() {
        this.hits = 0;
    }

    public int getHits() {
        int result = this.counterBean.getHits();
        return result;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

}
