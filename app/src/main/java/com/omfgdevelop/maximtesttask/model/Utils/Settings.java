package com.omfgdevelop.maximtesttask.model.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.view.View;

import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.model.interfaces.SettingsInterface;
import com.omfgdevelop.maximtesttask.view.interfaces.AuthFragmentInterface;

import static android.content.Context.MODE_PRIVATE;

public class Settings  implements AuthFragmentInterface.Model {
   private Credentials credentials;
   private Context context;
   private static final String STORAGE_NAME = "Settings";
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

        if(preferences==null){
            initEditor();
        }else {
            editor.putString("Login",credentials.getLogin());
            editor.putString("Password",credentials.getPassword());
            editor.commit();
        }


    }

    @Override
    public void delCredentials() {

    }

    @Override
    public Credentials getCredentials() {
        preferences = context.getSharedPreferences(STORAGE_NAME,MODE_PRIVATE);
        Credentials credentials = new Credentials();
        credentials.setLogin(preferences.getString("Login",null));
        credentials.setPassword(preferences.getString("Password",null));
        return credentials;
    }

    @Override
    public boolean checkIfExists() {
        if(preferences.contains("Login")){
            return true;
        }
        return false;
    }
}
