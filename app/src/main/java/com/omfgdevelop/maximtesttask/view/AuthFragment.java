package com.omfgdevelop.maximtesttask.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.omfgdevelop.maximtesttask.R;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.AuthInterface;
import com.omfgdevelop.maximtesttask.presenter.AuthPresenter;
import com.omfgdevelop.maximtesttask.presenter.MainActivityPresenter;
import com.omfgdevelop.maximtesttask.view.interfaces.AuthFragmentInterface;


public  class AuthFragment extends AbstractFragment implements AuthFragmentInterface.View {

    private AuthFragmentInterface.Presenter presenter;
    private EditText loginEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private AuthInterface authInterface;


    @Override
    protected int getLayout() {
        return R.layout.auth_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new AuthPresenter(this);
        loginEditText = view.findViewById(R.id.loginEditText);
        passwordEditText = view.findViewById(R.id.passwordEditText);
        loginButton = view.findViewById(R.id.logibButton);
//TEST
        loginEditText.setText("test_user");
        passwordEditText.setText("test_pass");
      //TEST
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              presenter.buttonClicked();
              }
        });
    }






    @Override
    public String getLogin() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void changeFragment(Boolean bool) {
        System.out.println("is suc "+bool);
        if(bool) {
            controllerPresenter.addFragment(new MainRecyclerViewFragment());
        }else {
            Toast.makeText(getContext()," Failed to check user data", Toast.LENGTH_SHORT).show();
        }
    }
}
