package com.omfgdevelop.maximtesttask.model.Utils.Network.Requests;

import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.model.Emplee.*;
import com.omfgdevelop.maximtesttask.model.Emplee.EmployeeData;
import com.omfgdevelop.maximtesttask.model.Utils.Network.RetrofitClient;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.EmployeeRequestInterface;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.RecyclerViewCallBackInterface;
import com.omfgdevelop.maximtesttask.view.TreeViewFragmetnInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeRequest implements TreeViewFragmetnInterface.Model.Request {

   EmployeeData employeeData;
   RecyclerViewCallBackInterface callBack;
   Credentials credentials;

    public EmployeeRequest(Credentials credentials) {
        this.employeeData = employeeData;
        this.callBack = callBack;
        this.credentials = credentials;
    }

    @Override
    public void getEmoloyees( final RecyclerViewCallBackInterface callBack) {
        employeeData = new EmployeeData();
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        try {
            final Call<EmployeeData> request = retrofitClient
                    .getRetrofitInterface()
                    .getEmployeeData(credentials.getLogin(), credentials.getPassword());
            request.enqueue(new Callback<EmployeeData>() {
                @Override
                public void onResponse(Call<EmployeeData> call, Response<EmployeeData> response) {
                   parceJson(response,callBack);
                }

                @Override
                public void onFailure(Call<EmployeeData> call, Throwable t) {

                    System.out.println(t.getMessage());
                }
            });


        }catch (Exception e){e.printStackTrace();}



    }
    void parceJson(Response<EmployeeData> response, RecyclerViewCallBackInterface callBack){
        if(response.isSuccessful()) {
            List<Office> officeList = new ArrayList<>();

            for (int i = 0; i < response.body().getOffices().size(); i++) {
                Office office = new Office();
                office.setDepartments(response.body().getOffices().get(i).getDepartments());
                office.setEmployees(response.body().getOffices().get(i).getEmployees());
                office.setID(response.body().getOffices().get(i).getID());
                office.setName(response.body().getOffices().get(i).getName());
                officeList.add(office);
            }
            employeeData.setName(response.body().getName());
            employeeData.setID(response.body().getID());
            employeeData.setOffices(officeList);
            callBack.callBack(employeeData);
        }else {

        }
    }
}

