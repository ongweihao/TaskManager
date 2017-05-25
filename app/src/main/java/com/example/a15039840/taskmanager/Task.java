package com.example.a15039840.taskmanager;

import java.io.Serializable;

/**
 * Created by 15039840 on 25/5/2017.
 */

public class Task implements Serializable {
    private int id;
    private String name;
    private String description;


    public Task(int id, String name, String description) {
        this.id= id;
        this.name=name;
        this.description=description;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
}
