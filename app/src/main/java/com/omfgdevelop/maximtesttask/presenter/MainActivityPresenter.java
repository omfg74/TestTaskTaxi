package com.omfgdevelop.maximtesttask.presenter;

import android.content.SharedPreferences;

import com.omfgdevelop.maximtesttask.ContentProvider;
import com.omfgdevelop.maximtesttask.view.interfaces.MainActivityInterface;

import static android.content.Context.MODE_PRIVATE;
import static com.omfgdevelop.maximtesttask.model.Utils.Settings.STORAGE_NAME;

public class MainActivityPresenter implements MainActivityInterface.Presenter {
    private MainActivityInterface.View view;

    public MainActivityPresenter(MainActivityInterface.View view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        view.setFabListner();
        view.attachFragmentToContainer();
    }

    @Override
    public void deleteSettings() {
        SharedPreferences sharedPreferences = ContentProvider.getContext().getSharedPreferences(STORAGE_NAME, MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }
}
