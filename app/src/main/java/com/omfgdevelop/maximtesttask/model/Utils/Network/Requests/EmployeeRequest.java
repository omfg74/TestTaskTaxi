package com.omfgdevelop.maximtesttask.model.Utils.Network.Requests;

import android.content.Context;
import android.util.Log;

import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.model.Emplee.Department;
import com.omfgdevelop.maximtesttask.model.Emplee.Department_;
import com.omfgdevelop.maximtesttask.model.Emplee.Department__;
import com.omfgdevelop.maximtesttask.model.Emplee.Employee;
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

                        for (int i = 0; i <response.body().size() ; i++) {
                            EmployeeData employeeData = new EmployeeData();
                            employeeData.setDepartments(response.body().get(i).getDepartments());
                            employeeData.setID(response.body().get(i).getID());
                            employeeData.setName(response.body().get(i).getName());
                            List<Department>departments = new ArrayList<>();
                            System.out.println(("JFIO GIOSRGFJHSEIOFR JESIOFJ SREIOFSEJF ISEOJF SREIOFJSEIO:F JSEIO:F JSEIOF:SEJFIO:E JFIO :SEJF SIE :FJ ESIOFJSEIO : FJSEIO:FJ SEIO:F "+response.body().get(i).getID()));
                            Log.d("JSON","response.body().get(i).getName() "+response.body().get(i).getName());
//                            Log.d("JSON",);
//                            Log.d("JSON",);
                            for (int j = 0; j <response.body().get(j).getDepartments().size() ; j++) {
                                Department department = new Department();
                                department.setDepartments(response.body().get(i).getDepartments().get(j).getDepartments());
                                department.setEmployees(response.body().get(i).getDepartments().get(j).getEmployees());
                                department.setID(response.body().get(j).getID());
                                department.setName(response.body().get(j).getName());
                                Log.d("JSON","response.body().get(j).getID() "+response.body().get(j).getID());
                                Log.d("JSON","response.body().get(j).getName() "+response.body().get(j).getName());
//                                Log.d("JSON",);
//                                Log.d("JSON",);
                                for (int k = 0; k <response.body().get(i).getDepartments().get(j).getDepartments().size() ; k++) {
                                    Department_ department_ = new Department_();
                                    department_.setDepartments(response.body().get(i).getDepartments().get(i).getDepartments().get(k).getDepartments());
                                    department_.setEmployees(response.body().get(i).getDepartments().get(i).getDepartments().get(k).getEmployees());
                                    department_.setID(response.body().get(i).getDepartments().get(i).getDepartments().get(k).getID());
                                    department_.setName(response.body().get(i).getDepartments().get(i).getDepartments().get(k).getName());
                                    Log.d("JSON"," response.body().get(i).getDepartments().get(i).getDepartments().get(k).getID() "+response.body().get(i).getDepartments().get(i).getDepartments().get(k).getID());
                                Log.d("JSON"," response.body().get(i).getDepartments().get(i).getDepartments().get(k).getName() " +response.body().get(i).getDepartments().get(i).getDepartments().get(k).getName());
                                    for (int l = 0; l <response.body().get(i).getDepartments().get(j).getDepartments().get(k).getDepartments().size() ; l++) {
                                        Department__ department__ = new Department__();
                                        department__.setEmployees(response.body().get(i).getDepartments().get(j).getDepartments().get(k).getDepartments().get(l).getEmployees());
                                        department__.setID(response.body().get(i).getDepartments().get(j).getDepartments().get(k).getDepartments().get(l).getID());
                                        department__.setName(response.body().get(i).getDepartments().get(j).getDepartments().get(k).getDepartments().get(l).getName());
                                        Log.d("JSON","last getID() "+response.body().get(i).getDepartments().get(j).getDepartments().get(k).getDepartments().get(l).getID());
                                        Log.d("JSON","last getName() "+response.body().get(i).getDepartments().get(j).getDepartments().get(k).getDepartments().get(l).getName());
                                    }
                                }
                                }
                        }
                    }else {

                    }
                }

                @Override
                public void onFailure(Call<List<EmployeeData>> call, Throwable t) {
//*
                    //
//                    Employee employee = new Employee();
//                    employee.setName(response.body().get(i).getDepartments().get(j).getEmployees().get(k).getName());
//                    employee.setEmail(response.body().get(i).getDepartments().get(j).getEmployees().get(k).getEmail());
//                    employee.setID(response.body().get(i).getDepartments().get(j).getEmployees().get(k).getID());
//                    employee.setPhone(response.body().get(i).getDepartments().get(j).getEmployees().get(k).getPhone());
//                    employee.setTitle(response.body().get(i).getDepartments().get(j).getEmployees().get(k).getTitle());
//                    Log.d("JSON",);
//                    Log.d("JSON",);
//                    Log.d("JSON",);
//                    Log.d("JSON",);
                }
            });

        }catch (Exception e){e.printStackTrace();}


    }
}
