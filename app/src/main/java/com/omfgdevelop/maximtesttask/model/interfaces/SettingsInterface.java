package com.omfgdevelop.maximtesttask.model.interfaces;

import android.content.Context;

import com.omfgdevelop.maximtesttask.model.Credentials;

public interface SettingsInterface {

    void init();
    void addCredentials(Credentials credentials);
    void delCredentials();
    Credentials getCredentials();
    boolean checkIfExists();
}
