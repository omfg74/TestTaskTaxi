package com.omfgdevelop.maximtesttask;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.omfgdevelop.maximtesttask.presenter.MainActivityPresenter;
import com.omfgdevelop.maximtesttask.view.AuthFragment;
import com.omfgdevelop.maximtesttask.view.TreeViewFragment;
import com.omfgdevelop.maximtesttask.view.interfaces.MainActivityInterface;

//import com.omfgdevelop.maximtesttask.view.AbstractFragment;


public class MainActivity extends AppCompatActivity implements MainActivityInterface.View {
    private MainActivityPresenter presenter;
    TreeViewFragment fragment;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainActivityPresenter(this);//
        presenter.onCreate();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    public void setFabListner() {
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab.setVisibility(View.INVISIBLE);
                presenter.onCreate();
            }
        });
    }
    @Override
    public void attachFragmentToContainer() {
        AuthFragment authFragment = new AuthFragment();
        fab.setVisibility(View.INVISIBLE);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_place, authFragment)
                .addToBackStack(null)
                .commit();
    }
    @Override
    public void onBackPressed() {//Механизм удаления данных работает, но не явно. Можно было сделать и кнопку, но такое поведение выглядит несколько более естественно
        FragmentManager fragmentManager = getSupportFragmentManager();
        if(fragmentManager.getBackStackEntryCount()!=2){
            fragmentManager.popBackStack();
        }else {
            fragmentManager.popBackStack();
          presenter.deleteSettings();
        }
    }
}