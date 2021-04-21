package com.ejbs.labs.server.beans.shoppingCart;

import com.ejbs.labs.server.exception.BookException;

import javax.ejb.Remote;
import javax.ejb.Remove;
import java.util.Set;

@Remote
public interface ShoppingCart {
    void initialize(String person) throws BookException;

    void addBook(String title);

    void removeBook(String title) throws BookException;

    Set<String> getContents();

    @Remove()
    void remove();
}
