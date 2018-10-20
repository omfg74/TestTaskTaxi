package com.omfgdevelop.maximtesttask.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omfgdevelop.maximtesttask.R;

public class EmployeeFragment extends AbstractFragment {
    @Override
    protected int getLayout() {
        return R.layout.employee_fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
