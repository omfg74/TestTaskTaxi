package com.omfgdevelop.maximtesttask.model.Utils.Network.Requests;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.omfgdevelop.maximtesttask.model.AuthData;
import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.model.Utils.Network.RetrofitClient;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.AuthInterface;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.EmployeeRequestInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRequest implements AuthInterface {
    AuthData authData = new AuthData();
    boolean isSuccessful;
    Credentials credentials;
    Context context;

    @Override
    public synchronized boolean getAuth(Credentials credentials, final Context context) {
        this.credentials = credentials;
        this.context = context;
        final RetrofitClient retrofitClient = RetrofitClient.getInstance();
        try{
            Call<AuthData> response = retrofitClient.getRetrofitInterface().getAuthData(credentials.getLogin(),credentials.getPassword());
            response.enqueue(new Callback<AuthData>() {
                @Override
                public void onResponse(Call<AuthData> call, Response<AuthData> response) {
                    handleResponse(response);

                }

                @Override
                public void onFailure(Call<AuthData> call, Throwable t) {
                    System.out.println("FAIL");
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();

        }
//        System.out.println("MESSAGE "+authData.getMessage());
//       if (authData.getSuccess().equals("true")){
//            return true;
//       }
        return isSuccessful;
    }
    private void handleResponse(Response<AuthData>response){
        if(response.isSuccessful()) {
            authData.setMessage(response.body().getMessage());
            authData.setSuccess(response.body().getSuccess());
            System.out.println("MESSAGE "+authData.getMessage());

               //сохранить настройки

          EmployeeRequest employeeRequest = new EmployeeRequest();
               employeeRequest.getEmoloyees(credentials,context);
//           }

//            Toast.makeText(context,""+response.body().getMessage(),Toast.LENGTH_SHORT).show();
        }

    }


}
