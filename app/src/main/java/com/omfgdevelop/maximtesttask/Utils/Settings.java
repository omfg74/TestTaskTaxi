package com.omfgdevelop.maximtesttask.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.omfgdevelop.maximtesttask.ContentProvider;
import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.view.interfaces.AuthFragmentInterface;

import static android.content.Context.MODE_PRIVATE;

public class Settings implements AuthFragmentInterface.Model.Settings {
    private Credentials credentials;
    private Context context;
    public static final String STORAGE_NAME = "Settings";
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private AuthFragmentInterface.View view;

    public Settings(SharedPreferences sharedPreferences) {
        this.preferences = sharedPreferences;
    }

    @Override
    public void initEditor() {
        editor = preferences.edit();
    }

    @Override
    public void addCredentials(Credentials credentials) {
        if (preferences == null) {
            initEditor();
        } else {
            editor.putString("Login", credentials.getLogin());
            editor.putString("Password", credentials.getPassword());
            editor.apply();
        }
    }

    @Override
    public void delCredentials() {
        SharedPreferences sharedPreferences = ContentProvider.getContext().getSharedPreferences(STORAGE_NAME, MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }

    @Override
    public Credentials getCredentials() {
        preferences = ContentProvider.getContext().getSharedPreferences(STORAGE_NAME, MODE_PRIVATE);
        Credentials credentials = new Credentials();
        credentials.setLogin(preferences.getString("Login", null));
        credentials.setPassword(preferences.getString("Password", null));
        return credentials;
    }

    @Override
    public boolean checkIfExists() {
        if (preferences.contains("Login")) {
            return true;
        }
        return false;
    }
}
