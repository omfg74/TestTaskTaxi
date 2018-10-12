package com.omfgdevelop.maximtesttask.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omfgdevelop.maximtesttask.view.interfaces.FragmentContract;

public abstract class AbstractFragment extends Fragment implements FragmentContract.View {
    private View view;


    private FragmentContract.Presenter controllerPresenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(getLayout(), container,false);
        return view;
    }

    protected abstract int getLayout();


    @Override
    public void attachPresenter(FragmentContract.Presenter presenter) {
        controllerPresenter = presenter;
    }
}
