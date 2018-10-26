package com.omfgdevelop.maximtesttask.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.omfgdevelop.maximtesttask.R;
import com.omfgdevelop.maximtesttask.model.AbstractEmployee;
import com.omfgdevelop.maximtesttask.presenter.EmployeePresenrter;
import com.omfgdevelop.maximtesttask.view.interfaces.EmployeeInterFace;


public class EmployeeFragment extends Fragment implements EmployeeInterFace.View {

    View view;
    ImageView imageView;
    TextView empNameTextView, empIDTextView, empEmailTextView, empTitleTextView, empPhoneTextView;
    EmployeeInterFace.Presenter presenrter;
    Bundle bundle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         view = inflater.inflate(R.layout.employee_fragment,container,false);
         return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bundle = getArguments();
        presenrter.onCreate(bundle);
        setListners();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenrter = new EmployeePresenrter(this);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void setImage(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }
    @Override
    public void startNewActivity(Intent intent) {
        startActivity(intent);
    }
    @Override
    public void setViews() {
        imageView = (ImageView) getActivity().findViewById(R.id.employeeImageView);
        empNameTextView = getActivity().findViewById(R.id.empNameTextView);
        empIDTextView = getActivity().findViewById(R.id.empIDTextView);
        empEmailTextView = getActivity().findViewById(R.id.empEmailTextView);
        empPhoneTextView = getActivity().findViewById(R.id.empPhoneTextView);
        empTitleTextView = getActivity().findViewById(R.id.empTitleTextView);
    }

    @Override
    public void setText(AbstractEmployee abstractEmployee) {
        empNameTextView.setText("Name " + abstractEmployee.getName());
        empIDTextView.setText("ID " + abstractEmployee.getID());
        if (abstractEmployee.getEmail() != null) {
            empEmailTextView.setText("E-mail " + abstractEmployee.getEmail());
        }

        empPhoneTextView.setText("tel " + abstractEmployee.getPhone());
        empTitleTextView.setText("Title " + abstractEmployee.getTitle());
    }

    @Override
    public void setListners() {
        empPhoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenrter.phoneCkicked(empPhoneTextView.getText().toString());
                Toast.makeText(getContext(), "PHONE " + empPhoneTextView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        empEmailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenrter.emailClicked(empEmailTextView.getText().toString());
                Toast.makeText(getContext(), "Email " + empEmailTextView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
