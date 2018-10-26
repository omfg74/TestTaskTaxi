package com.omfgdevelop.maximtesttask.Utils.Network.Requests;

import com.omfgdevelop.maximtesttask.model.AuthData;
import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.Utils.Network.RetrofitClient;
import com.omfgdevelop.maximtesttask.Utils.Network.interfaces.AuthCallBackInterface;
import com.omfgdevelop.maximtesttask.Utils.Network.interfaces.AuthRequestInterface;
import com.omfgdevelop.maximtesttask.presenter.MainActivityPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRequest implements AuthRequestInterface {
    AuthData authData = new AuthData();
    boolean isSuccessful;
    Credentials credentials;
    AuthCallBackInterface authCallBackInterface;
    private MainActivityPresenter presenter;


    public AuthRequest(Credentials credentials, AuthCallBackInterface authCallBackInterface) {
        this.credentials = credentials;
        this.authCallBackInterface = authCallBackInterface;
    }


    @Override
    public void createAuthRequest() {
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        try {
            Call<AuthData> response = retrofitClient.getRetrofitInterface().getAuthData(credentials.getLogin(), credentials.getPassword());
            response.enqueue(new Callback<AuthData>() {
                @Override
                public void onResponse(Call<AuthData> call, Response<AuthData> response) {
                    if (response.isSuccessful()) {
                        authData.setMessage(response.body().getMessage());
                        authData.setSuccess(response.body().getSuccess());
                        System.out.println("MESSAGE " + authData.getSuccess());
                        authCallBackInterface.callBackCall(authData);

                    }
                }

                @Override
                public void onFailure(Call<AuthData> call, Throwable t) {
                    System.out.println("FAIL");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();

        }
    }
}
