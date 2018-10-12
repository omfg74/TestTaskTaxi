package com.omfgdevelop.maximtesttask.model;

import android.util.Log;

import com.omfgdevelop.maximtesttask.view.interfaces.AuthFragmentInterface;

import java.io.Serializable;

public class Credentials implements Serializable, AuthFragmentInterface.Model {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void getAuth(Credentials credentials) {

        Log.d("LOG", credentials.getLogin() + " "+ credentials.getPassword());
    }
}
