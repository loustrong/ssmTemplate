package com.tom.ssm.springmvc.chapter02.chapter0202.requestBody.domain;

import java.io.Serializable;

/**
 * Book
 *
 * @author Tom on 2021/2/11
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String author;

    public Book() {
    }

    public Book(Integer id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
