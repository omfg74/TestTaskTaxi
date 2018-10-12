package com.omfgdevelop.maximtesttask.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Departmet implements Serializable {

    private String Name;
    private ArrayList<EmploeeItem> emploeeItems;


    public void setName(String name) {
        Name = name;
    }

    public void setEmploeeItems(ArrayList<EmploeeItem> emploeeItems) {
        this.emploeeItems = emploeeItems;
    }

    public String getName() {

        return Name;
    }

    public ArrayList<EmploeeItem> getEmploeeItems() {
        return emploeeItems;
    }
}
