package com.omfgdevelop.maximtesttask.model.Utils.Network.Requests;

import android.content.Context;
import android.widget.Toast;

import com.omfgdevelop.maximtesttask.model.AuthData;
import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.model.Utils.Network.RetrofitClient;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.AuthInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRequest implements AuthInterface {
    AuthData authData = new AuthData();
    boolean isSuccessful;

    @Override
    public boolean getAuth(Credentials credentials, final Context context) {
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        try{
            Call<AuthData> response = retrofitClient.getRetrofitInterface().getAuthData(credentials.getLogin(),credentials.getPassword());
            response.enqueue(new Callback<AuthData>() {
                @Override
                public void onResponse(Call<AuthData> call, Response<AuthData> response) {
                    if(response.isSuccessful()) {
                        authData.setMessage(response.body().getMessage());
                        authData.setSuccess(response.body().getSuccess());
                    }else {
                        Toast.makeText(context,""+response.body().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<AuthData> call, Throwable t) {

                }
            });
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();

        }

        return isSuccessful;
    }


}
