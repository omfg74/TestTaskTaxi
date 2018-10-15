package com.omfgdevelop.maximtesttask.model.Utils.Network.Requests;

import android.content.Context;

import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.model.Emplee.EmployeeData;
import com.omfgdevelop.maximtesttask.model.Utils.Network.RetrofitClient;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.EmployeeRequestInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeRequest implements EmployeeRequestInterface {

    List<EmployeeData> employeeDataList = new ArrayList<>();
    @Override
    public void getEmoloyees(Credentials credentials, Context context) {

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        try{
            final Call<List<EmployeeData>> request = retrofitClient
                    .getRetrofitInterface()
                    .getEmployeeData(credentials.getLogin(),credentials.getPassword());
            request.enqueue(new Callback<List<EmployeeData>>() {
                @Override
                public void onResponse(Call<List<EmployeeData>> call, Response<List<EmployeeData>> response) {
                    if(response.isSuccessful()){

                    }else {

                    }
                }

                @Override
                public void onFailure(Call<List<EmployeeData>> call, Throwable t) {

                }
            });

        }catch (Exception e){e.printStackTrace();}


    }
}
