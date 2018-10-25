package com.omfgdevelop.maximtesttask.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.omfgdevelop.maximtesttask.MainActivity;
import com.omfgdevelop.maximtesttask.R;
import com.omfgdevelop.maximtesttask.model.AbstractEmployee;
import com.omfgdevelop.maximtesttask.presenter.EmployeePresenrter;
import com.omfgdevelop.maximtesttask.view.interfaces.EmployeeInterFace;


public class EmployeeFragment extends AbstractFragment implements EmployeeInterFace.View {

    ImageView imageView;
    TextView empNameTextView,empIDTextView,empEmailTextView,empTitleTextView,empPhoneTextView;
    EmployeeInterFace.Presenter presenrter;
    @Override
    protected int getLayout() {
        return R.layout.employee_fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

       return super.onCreateView(inflater, container, savedInstanceState);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        AbstractEmployee abstractEmployee= (AbstractEmployee) bundle.getSerializable("employee");
        setViews();
        setText(abstractEmployee);
        setListners();
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("Login", null);
        String password = sharedPreferences.getString("Password", null);
        presenrter.fetchImage(abstractEmployee.getID(),name, password);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenrter = new EmployeePresenrter(this);

    }

    @Override
    public void onResume() {
        super.onResume();
//        MainActivity.fab.setVisibility(View.VISIBLE);

    }

    @Override
    public void setImage(Bitmap bitmap) {

        imageView.setImageBitmap(bitmap);

    }


    @Override
    public void startNewActivity(Intent intent) {
        Log.d("Intebt",""+intent);
        startActivity(intent);
    }

    private void setViews(){
        imageView = (ImageView) getActivity().findViewById(R.id.employeeImageView);
        empNameTextView = getActivity().findViewById(R.id.empNameTextView);
        empIDTextView = getActivity().findViewById(R.id.empIDTextView);
        empEmailTextView = getActivity().findViewById(R.id.empEmailTextView);
        empPhoneTextView = getActivity().findViewById(R.id.empPhoneTextView);
        empTitleTextView = getActivity().findViewById(R.id.empTitleTextView);
    }

    private void setText(AbstractEmployee abstractEmployee){
        empNameTextView.setText("Name "+abstractEmployee.getName());
        empIDTextView.setText("ID "+abstractEmployee.getID());
        if(abstractEmployee.getEmail()!=null){
            empEmailTextView.setText("E-mail "+abstractEmployee.getEmail());
        }

        empPhoneTextView.setText("tel "+abstractEmployee.getPhone());
        empTitleTextView.setText("Title "+ abstractEmployee.getTitle());
    }

    private void setListners(){
        empPhoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenrter.phoneCkicked(empPhoneTextView.getText().toString());
                Toast.makeText(getContext(), "PHONE "+empPhoneTextView.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        empEmailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenrter.emailClicked(empEmailTextView.getText().toString());
                Toast.makeText(getContext(), "Email "+empEmailTextView.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
