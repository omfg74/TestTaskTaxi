package com.omfgdevelop.maximtesttask.presenter;

import android.content.Context;

import com.omfgdevelop.maximtesttask.ContentProvider;
import com.omfgdevelop.maximtesttask.model.AuthData;
import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.Utils.Network.Requests.AuthRequest;
import com.omfgdevelop.maximtesttask.Utils.Network.interfaces.AuthCallBackInterface;
import com.omfgdevelop.maximtesttask.Utils.Network.interfaces.AuthRequestInterface;
import com.omfgdevelop.maximtesttask.Utils.Settings;
import com.omfgdevelop.maximtesttask.view.interfaces.AuthFragmentInterface;

//import com.omfgdevelop.maximtesttask.Utils.Network.interfaces.AuthInterface;

public class AuthPresenter implements AuthFragmentInterface.Presenter, AuthCallBackInterface {
    private AuthFragmentInterface.View view;
    private AuthFragmentInterface.Model.Settings model;
    private Credentials credentials;

    public AuthPresenter(AuthFragmentInterface.View view) {
        this.view = view;
        this.model = new Settings(ContentProvider.getContext().getSharedPreferences(Settings.STORAGE_NAME, Context.MODE_PRIVATE));
    }

    @Override
    public void onCreate() {
        view.setElements();
        view.setButton();
        view.setTestText();
        checkSettings();
    }

    @Override
    public void buttonClicked() {
        credentials = new Credentials();
        if (!model.checkIfExists()) {
            credentials.setLogin(view.getLogin());
            credentials.setPassword(view.getPassword());
            AuthRequestInterface authRequest = new AuthRequest(credentials, this);
            authRequest.createAuthRequest();
        } else {
            view.setText("Welcome Back");
            view.attachFragmentToContainer();
        }
    }

    @Override
    public void checkSettings() {
        if (model.checkIfExists()) {
            view.attachFragmentToContainer();

        }
    }

    @Override
    public void callBackCall(AuthData authData) {
        if (authData.getSuccess() == true) {
            if (!model.checkIfExists())
                model.initEditor();
            model.addCredentials(credentials);
            view.setText("Saved");
            view.attachFragmentToContainer();
        } else {
            view.setText("Wrong user name or password");
        }
    }


}


