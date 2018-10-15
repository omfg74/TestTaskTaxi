package com.omfgdevelop.maximtesttask.presenter;

import android.content.Context;

import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.model.Utils.CredentialsChecker;
import com.omfgdevelop.maximtesttask.model.interfaces.CredentialCheckerInterface;
import com.omfgdevelop.maximtesttask.view.interfaces.AuthFragmentInterface;

public class AuthPresenter implements AuthFragmentInterface.Presenter {
    private AuthFragmentInterface.View view;
    private AuthFragmentInterface.Model model;
    private Context context;

    public AuthPresenter(AuthFragmentInterface.View view) {
        this.view = view;

    }

    @Override
    public void buttonClicked() {
        //Уточнить этот момент
       model= new Credentials();
//        view.getLogin());
//        credentials.setPassword(view.getPassword());
        ((Credentials) model).setLogin(view.getLogin());
        ((Credentials) model).setPassword(view.getPassword());
        model.getAuth((Credentials)model);



    }


}
