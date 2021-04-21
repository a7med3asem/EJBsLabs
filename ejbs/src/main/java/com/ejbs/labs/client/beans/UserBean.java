package com.ejbs.labs.client.beans;

import com.ejbs.labs.server.beans.sayHello.SayHello;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {
    @EJB
    private SayHello hello;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String sayHelloUsingEJB() {
        String message = hello.sayHello(name);
        setName(message);

        return "hello";
    }
}
