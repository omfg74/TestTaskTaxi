package com.omfgdevelop.maximtesttask;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.omfgdevelop.maximtesttask.view.MainRecyclerViewFragment;
import com.omfgdevelop.maximtesttask.view.MainRecyclerViewFragmentInterface;


public class MainActivity extends AppCompatActivity {

MainRecyclerViewFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = new MainRecyclerViewFragment();
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_fragment_place, fragment).commit();
    }
}