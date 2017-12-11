package com.money.entity;

import java.io.Serializable;

public class Role implements Serializable{

    private int roid;
    private String roname;

    public int getRoid() {
        return roid;
    }

    public void setRoid(int roid) {
        this.roid = roid;
    }

    public String getRoname() {
        return roname;
    }

    public void setRoname(String roname) {
        this.roname = roname;
    }
}
