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

import com.omfgdevelop.maximtesttask.R;
import com.omfgdevelop.maximtesttask.presenter.AuthPresenter;
import com.omfgdevelop.maximtesttask.view.interfaces.AuthFragmentInterface;


public class AuthFragment extends AbstractFragment implements AuthFragmentInterface.View {

    private AuthFragmentInterface.Presenter presenter;
    private EditText loginEditText;
    private EditText passwordEditText;
    private Button loginButton;


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

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.buttonClicked();
            }
        });
    }


    @Override
    public String getLogin() {
        return loginEditText.getText().toString();

    }

    @Override
    public String getPassword() {
        return passwordEditText.getText().toString();
    }
}
