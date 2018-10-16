package com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces;

import com.omfgdevelop.maximtesttask.model.AuthData;
import com.omfgdevelop.maximtesttask.model.Emplee.EmployeeData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitInterface {
    @GET("Hello?")
    Call<AuthData> getAuthData(@Query("login")String login, @Query("password")String password);
//    void  getAuthData(@Query("login")String login, @Query("password")String password, Callback<AuthData> callback);
    @GET("GetAll?")
    Call<List<EmployeeData>> getEmployeeData(@Query("login")String login, @Query("password")String password);
}
