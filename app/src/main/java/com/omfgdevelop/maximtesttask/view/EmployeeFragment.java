package com.omfgdevelop.maximtesttask.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omfgdevelop.maximtesttask.R;
import com.omfgdevelop.maximtesttask.model.AbstractEmployee;
import com.omfgdevelop.maximtesttask.model.Emplee.Employee;
import com.omfgdevelop.maximtesttask.presenter.EmployeePresenrter;
import com.omfgdevelop.maximtesttask.view.interfaces.EmployeeInterFace;

public class EmployeeFragment extends AbstractFragment implements EmployeeInterFace.View {

    EmployeeInterFace.Presenter presenrter;
    @Override
    protected int getLayout() {
        return R.layout.employee_fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       Bundle bundle = getArguments();
        AbstractEmployee abstractEmployee= (AbstractEmployee) bundle.getSerializable("employee");
        System.out.println(abstractEmployee.getName());
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void setImage() {

    }

    @Override
    public void setText() {

    }
}
