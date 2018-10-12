package com.omfgdevelop.maximtesttask.model;

import android.media.Image;

import java.io.Serializable;

public class EmploeeItem implements Serializable {

    private String name;
    private String phone;
    private Image photo;


    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public String getName() {

        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Image getPhoto() {
        return photo;
    }
}
