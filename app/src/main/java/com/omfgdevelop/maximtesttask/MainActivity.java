package com.omfgdevelop.maximtesttask;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.omfgdevelop.maximtesttask.presenter.MainActivityPresenter;
import com.omfgdevelop.maximtesttask.view.AbstractFragment;
import com.omfgdevelop.maximtesttask.view.TreeViewFragment;
import com.omfgdevelop.maximtesttask.view.interfaces.MainActivityInterface;


public class MainActivity extends AppCompatActivity implements MainActivityInterface.View {
private MainActivityPresenter presenter;
TreeViewFragment fragment;
   public static FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainActivityPresenter(this);


         fab = findViewById(R.id.fab);
        fab.setVisibility(View.INVISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("settings",MODE_PRIVATE);
                sharedPreferences.edit().clear().commit();
               presenter.getFragment();
            }
        });
        presenter.getFragment();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStart() {
        super.onStart();
        fab.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setFragment(AbstractFragment fragment) {
        fab.setVisibility(View.VISIBLE);
        fragment.attachPresenter(presenter);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_place,fragment)
                .addToBackStack(null)
                .commit();
    }
}