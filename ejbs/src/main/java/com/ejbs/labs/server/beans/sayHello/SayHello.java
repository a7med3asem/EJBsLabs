package com.ejbs.labs.server.beans.sayHello;

import javax.ejb.Local;
import javax.ejb.Remote;

@Remote
public interface SayHello {
    String sayHello(String name);

}
