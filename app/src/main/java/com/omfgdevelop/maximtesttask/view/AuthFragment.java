package com.omfgdevelop.maximtesttask.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.omfgdevelop.maximtesttask.R;
import com.omfgdevelop.maximtesttask.presenter.AuthPresenter;
import com.omfgdevelop.maximtesttask.view.interfaces.AuthFragmentInterface;


public class AuthFragment extends Fragment implements AuthFragmentInterface.View {

    private AuthFragmentInterface.Presenter presenter;
    private EditText loginEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.auth_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new AuthPresenter(this);
        presenter.onCreate();
    }

    @Override
    public void attachFragmentToContainer() {
        TreeViewFragment treeViewFragment = new TreeViewFragment();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .remove(this)
                .replace(R.id.main_fragment_place, treeViewFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public String getLogin() {
        return loginEditText.getText().toString();
    }

    @Override
    public String getPassword() {
        return passwordEditText.getText().toString();
    }

    @Override
    public void setElements() {
        loginEditText = view.findViewById(R.id.loginEditText);
        passwordEditText = view.findViewById(R.id.passwordEditText);
    }

    @Override
    public void setButton() {
        loginButton = view.findViewById(R.id.logibButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.buttonClicked();
            }
        });
    }

    @Override
    public void setText(String str) {
        Toast.makeText(getContext(), str, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setTestText() {
        //Данные введены для удобства проверки и тестирования.
        loginEditText.setText("test_user");
        passwordEditText.setText("test_pass");
    }
}
