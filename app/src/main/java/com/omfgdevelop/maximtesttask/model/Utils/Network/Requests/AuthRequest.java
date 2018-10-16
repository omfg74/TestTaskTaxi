package com.omfgdevelop.maximtesttask.model.Utils.Network.Requests;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.omfgdevelop.maximtesttask.model.AuthData;
import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.model.Utils.Network.RetrofitClient;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.AuthInterface;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.EmployeeRequestInterface;
import com.omfgdevelop.maximtesttask.view.AbstractFragment;
import com.omfgdevelop.maximtesttask.view.MainRecyclerViewFragment;
import com.omfgdevelop.maximtesttask.view.interfaces.FragmentContract;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRequest{
    AuthData authData = new AuthData();
    boolean isSuccessful;
    Credentials credentials;
    Context context;


    public boolean getAuthResponse(Credentials credentials, final Context context) {
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
//                    System.out.println("FAIL");
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
        System.out.println("Is sucsessful"+isSuccessful);
        return isSuccessful;
    }

    private void handleResponse(final Response<AuthData>response){
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {

        if(response.isSuccessful()) {
            authData.setMessage(response.body().getSuccess());
            System.out.println(response.body().getMessage());
            authData.setSuccess(response.body().getSuccess());
            System.out.println("MESSAGE "+authData.getSuccess());
            if (authData.getSuccess().toString().equals("true")){
                isSuccessful=true;
                System.out.println(isSuccessful);
            }else {
                System.out.println("Error auth "+authData.getMessage()+" "+authData.getSuccess());
            }

            }else {
            Log.d("Log","Error reting respond");
        }
                Log.d("UI thread", "I am the UI thread");
            }
        });
               //сохранить настройки

//           }

//            Toast.makeText(context,""+response.body().getMessage(),Toast.LENGTH_SHORT).show();


    }


}
