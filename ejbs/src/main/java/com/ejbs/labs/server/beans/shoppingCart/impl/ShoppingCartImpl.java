package com.ejbs.labs.server.beans.shoppingCart.impl;

import com.ejbs.labs.server.exception.BookException;
import com.ejbs.labs.server.beans.shoppingCart.ShoppingCart;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Stateful
public class ShoppingCartImpl implements Serializable, ShoppingCart {
    String customerId;
    String customerName;
    Set<String> contents;

    public ShoppingCartImpl() {
    }

    @Override
    public void initialize(String person) throws BookException {
        if (person == null) {
            throw new BookException("Null person not allowed.");
        } else {
            customerName = person;
        }
        customerId = "0";
        contents = new HashSet<>();
    }

    @Override
    public void addBook(String title) {
        contents.add(title);
    }

    @Override
    public void removeBook(String title) throws BookException {
        boolean result = contents.remove(title);
        if (result == false) {
            throw new BookException(title + " not in cart.");
        }
    }

    @Override
    public Set<String> getContents() {
        return contents;
    }

    @Remove()
    @Override
    public void remove() {
        contents = null;
    }
}
