
package com.ejbs.labs.server.beans.hits;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;


@Singleton
@LocalBean
public class StatusBean {

    private String status;
    
    @PostConstruct
    void init(){
        status = "Ready";
    }
    
    
    
}
