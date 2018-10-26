package com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces;

import com.omfgdevelop.maximtesttask.model.AuthData;
import com.omfgdevelop.maximtesttask.model.Employee.EmployeeData;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RetrofitInterface {
    @GET("Hello?")
    Call<AuthData> getAuthData(@Query("login") String login, @Query("password") String password);

    //    void  getAuthData(@Query("login")String login, @Query("password")String password, Callback<AuthData> callback);
    @GET("GetAll?")
    Call<EmployeeData> getEmployeeData(@Query("login") String login, @Query("password") String password);

    @GET
    Call<ResponseBody> downloadFileWithDynamicUrlSync(@Url String fileUrl);
}
