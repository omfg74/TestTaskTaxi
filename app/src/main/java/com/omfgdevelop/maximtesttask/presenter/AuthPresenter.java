package com.omfgdevelop.maximtesttask.presenter;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.omfgdevelop.maximtesttask.model.AuthData;
import com.omfgdevelop.maximtesttask.model.Credentials;
//import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.AuthInterface;
import com.omfgdevelop.maximtesttask.model.Utils.Network.Requests.AuthRequest;
import com.omfgdevelop.maximtesttask.model.Utils.Network.RetrofitClient;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.AuthCallBackInterface;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.AuthRequestInterface;
import com.omfgdevelop.maximtesttask.model.Utils.Settings;
import com.omfgdevelop.maximtesttask.view.interfaces.AuthFragmentInterface;

import javax.sql.StatementEvent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthPresenter implements AuthFragmentInterface.Presenter,AuthCallBackInterface {
    private AuthFragmentInterface.View view;
    private AuthFragmentInterface.Model model;

    private Credentials credentials;
    private Settings settings;
    public AuthPresenter(AuthFragmentInterface.View view) {
        this.view = view;

    }

    @Override
    public void buttonClicked() {
        //Уточнить этот момент
       settings = new Settings();
        credentials = new Credentials();
        settings.getPreferences();
        if(!settings.checkIfExists()){
            view.setText("No data");
        credentials.setLogin(view.getLogin());
        credentials.setPassword(view.getPassword());
        AuthRequestInterface authRequest = new AuthRequest(credentials, this);
                authRequest.createAuthRequest();
    }else {
            view.setText("Welcome Back");//add string value
            view.changeFragment();
        }
    }

    @Override
    public void callBackCall(AuthData authData) {//можно возвращать учетные данные и здесь
        if (authData.getSuccess() == true) {
            settings.getPreferences();
            settings.addCredentials(credentials);
            view.setText("Saved");
            view.changeFragment();//Смена фрагмента
        }
    }
}

