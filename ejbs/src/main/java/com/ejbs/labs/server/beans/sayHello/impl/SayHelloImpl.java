package com.ejbs.labs.server.beans.sayHello.impl;

import com.ejbs.labs.server.beans.sayHello.SayHello;

import javax.ejb.Stateless;

@Stateless
public class SayHelloImpl implements SayHello {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
