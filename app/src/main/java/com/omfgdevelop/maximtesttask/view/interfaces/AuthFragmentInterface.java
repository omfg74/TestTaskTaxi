package com.omfgdevelop.maximtesttask.view.interfaces;

import android.util.Log;

import com.omfgdevelop.maximtesttask.model.Credentials;

public interface AuthFragmentInterface {
    interface View{
        String getLogin();
        String getPassword();
    }
    interface Presenter{

        void buttonClicked();

    }
    interface Model{

        void getAuth(Credentials credentials);


    }
}
