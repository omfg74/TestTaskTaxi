package com.omfgdevelop.maximtesttask.presenter;

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

    private Credentials credentials;
    public AuthPresenter(AuthFragmentInterface.View view, AuthFragmentInterface.Model.Settings model) {
        this.view = view;
        this.model = model;

    }

    @Override
    public void buttonClicked() {
        //Уточнить этот момент

        credentials = new Credentials();
        if(!model.checkIfExists()){

        credentials.setLogin(view.getLogin());
        credentials.setPassword(view.getPassword());
        AuthRequestInterface authRequest = new AuthRequest(credentials, this);
                authRequest.createAuthRequest();
    }else {
//            if(credentials.getLogin().equals(model.getCredentials().getLogin())||credentials.getPassword().equals(model.getCredentials().getPassword())){
            view.setText("Welcome Back");//add string value
            view.changeFragment();
//        }else {
//                view.setText("Wrong login or password");
//            }
        }
    }

    @Override
    public void callBackCall(AuthData authData) {
        if (authData.getSuccess() == true) {
            if(!model.checkIfExists())
            model.initEditor();
            model.addCredentials(credentials);
            view.setText("Saved");
            view.changeFragment();//Смена фрагмента
        }else {
            view.setText("Wrong user name or password");
        }

        }
    }


