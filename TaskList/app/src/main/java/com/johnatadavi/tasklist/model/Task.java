package com.johnatadavi.tasklist.model;

import java.io.Serializable;

// implements Serializable
public class Task implements Serializable {

    private Long id;
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public Task(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Task() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
