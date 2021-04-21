package com.ejbs.labs.client.beans;

import com.ejbs.labs.server.beans.shoppingCart.ShoppingCart;
import com.ejbs.labs.server.exception.BookException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Set;

@Named(value = "cartBean")
@SessionScoped
public class CartBean implements Serializable {
    private Set<String> content;
    private String book;
    private String amount = "0";

    @EJB
    private ShoppingCart shoppingCart;

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    @PostConstruct
    void init() {
        try {
            shoppingCart.initialize("Asim");
        } catch (BookException e) {
            e.printStackTrace();
        }
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Set<String> getContent() {
        return shoppingCart.getContents();
    }

    public void setContent(Set<String> content) {
        this.content = content;
    }

    public void addBook() {
        shoppingCart.addBook(book);
    }

    public void removeBook() {
        try {

            shoppingCart.removeBook(book);
        } catch (BookException e) {
            e.printStackTrace();
        }
    }
}
