package com.omfgdevelop.maximtesttask.presenter;

import android.content.SharedPreferences;

import com.omfgdevelop.maximtesttask.view.AbstractFragment;
import com.omfgdevelop.maximtesttask.view.AuthFragment;
import com.omfgdevelop.maximtesttask.view.interfaces.FragmentContract;
import com.omfgdevelop.maximtesttask.view.interfaces.MainActivityInterface;

public class MainActivityPresenter implements MainActivityInterface.Presenter,FragmentContract.Presenter {
    private MainActivityInterface.View view;
    public MainActivityPresenter(MainActivityInterface.View view){
        this.view = view;
    }
    @Override
    public void addFragment(AbstractFragment fragment) {
        view.setFragment(fragment);
    }

    @Override
    public void getFragment() {
       view.setFragment(new AuthFragment());
    }

    public void clearSettings(SharedPreferences sharedPreferences){
        sharedPreferences.edit().clear().commit();
    }
}
