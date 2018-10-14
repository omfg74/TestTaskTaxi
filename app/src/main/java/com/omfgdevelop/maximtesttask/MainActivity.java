package com.omfgdevelop.maximtesttask;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.omfgdevelop.maximtesttask.presenter.MainActivityPresenter;
import com.omfgdevelop.maximtesttask.view.AbstractFragment;
import com.omfgdevelop.maximtesttask.view.MainRecyclerViewFragment;
import com.omfgdevelop.maximtesttask.view.interfaces.MainActivityInterface;


public class MainActivity extends AppCompatActivity implements MainActivityInterface.View {
private MainActivityPresenter presenter;
MainRecyclerViewFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainActivityPresenter(this);
        presenter.getFragment();
    }

    @Override
    public void setFragment(AbstractFragment fragment) {
        fragment.attachPresenter(presenter);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_place,fragment)
                .addToBackStack(null)
                .commit();
    }
}