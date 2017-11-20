package com.example.bojansolution.culinar.model;

/**
 * Created by bojan solution on 11/11/2017.
 */

public class Curtner {
    private Integer id;
    private String name;
    private int status;

    public Curtner(){
    }

    public Curtner(Integer id, String name, int status) {
        this.id = id;
        this.name = name;
        this.status = status;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Curtner '" + getName() + "'" +
                " is " + getStatus();
    }
}
