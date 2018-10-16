package com.omfgdevelop.maximtesttask.view.interfaces;

import android.content.Context;
import android.util.Log;

import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.AuthInterface;

public interface AuthFragmentInterface {
    interface View{
        String getLogin();
        String getPassword();
        void changeFragment(Boolean bool);
    }
    interface Presenter{

        void buttonClicked();


    }
    interface Model{

      static   void getAuth(AuthInterface callback){

      }


    }
}
