package com.omfgdevelop.maximtesttask.presenter;

import android.content.Context;
import android.support.v4.widget.AutoScrollHelper;

import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.model.Utils.AuthWorkwer;
import com.omfgdevelop.maximtesttask.model.Utils.CredentialsChecker;
import com.omfgdevelop.maximtesttask.model.Utils.Network.Requests.AuthRequest;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.AuthInterface;
import com.omfgdevelop.maximtesttask.model.interfaces.CredentialCheckerInterface;
import com.omfgdevelop.maximtesttask.view.AbstractFragment;
import com.omfgdevelop.maximtesttask.view.MainRecyclerViewFragment;
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
        Credentials credentials = new Credentials();
        credentials.setLogin(view.getLogin());
        credentials.setPassword(view.getPassword());
//        boolean bool = model.getAuth(credentials,context);
        AuthWorkwer.getAuth(new AuthInterface() {
            @Override
            public void authResult(Boolean bool) {

                view.changeFragment(bool);
            }
        });

    }


}
