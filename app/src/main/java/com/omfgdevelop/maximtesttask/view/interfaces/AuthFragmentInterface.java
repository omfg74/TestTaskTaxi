package com.omfgdevelop.maximtesttask.view.interfaces;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.omfgdevelop.maximtesttask.model.Credentials;


public interface AuthFragmentInterface {
    interface View{
        String getLogin();
        String getPassword();
        void changeFragment();
        void setText(String str);
    }
    interface Presenter{

        void buttonClicked();


    }
    interface Model{
        interface Settings{
void initEditor();
void  addCredentials(Credentials credentials);
        void delCredentials();
        Credentials getCredentials();
       boolean checkIfExists();
    }
}
}
