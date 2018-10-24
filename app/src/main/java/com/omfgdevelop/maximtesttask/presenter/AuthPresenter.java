package com.omfgdevelop.maximtesttask.presenter;

import android.content.Context;
import android.content.SharedPreferences;
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
    private AuthFragmentInterface.Model.Settings model;
    private Context context;
    private static

    private Credentials credentials;
    public AuthPresenter(AuthFragmentInterface.View view) {
        this.view = view;
        context = getContext();
        this.model = new Settings(context.getSharedPreferences("settings",Context.MODE_PRIVATE));
    }
    @Override
    public void onCreate() {
        view.setElements();
        view.setButton();
        view.setTestText();
    }
    @Override
    public void buttonClicked() {
        credentials = new Credentials();
        if(!model.checkIfExists()){
        credentials.setLogin(view.getLogin());
        credentials.setPassword(view.getPassword());
        AuthRequestInterface authRequest = new AuthRequest(credentials, this);
                authRequest.createAuthRequest();
    }else {
            view.setText("Welcome Back");
        }
    }
    @Override
    public void checkSettings() {
        if(model.checkIfExists()){
           view.attachFragmentToContainer();
        }
    }
    @Override
    public void callBackCall(AuthData authData) {
        if (authData.getSuccess() == true) {
            if(!model.checkIfExists())
            model.initEditor();
            model.addCredentials(credentials);
            view.setText("Saved");
        }else {
            view.setText("Wrong user name or password");
        }}}


