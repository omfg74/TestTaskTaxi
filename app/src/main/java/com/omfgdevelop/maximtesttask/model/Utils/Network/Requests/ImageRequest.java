package com.omfgdevelop.maximtesttask.model.Utils.Network.Requests;

import com.omfgdevelop.maximtesttask.model.Utils.Network.RetrofitClient;
import com.omfgdevelop.maximtesttask.view.interfaces.EmployeeImageCallBack;
import com.omfgdevelop.maximtesttask.view.interfaces.EmployeeInterFace;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageRequest implements EmployeeInterFace.Model {
    private EmployeeInterFace.Presenter presenter;
    private EmployeeImageCallBack callBack;
    private String url;

    public ImageRequest(EmployeeInterFace.Presenter presenter, EmployeeImageCallBack callBack, String url) {
        this.presenter = presenter;
        this.callBack = callBack;
        this.url = url;
    }

    @Override
    public void getImage() {

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        try {
            Call<ResponseBody> response = retrofitClient.getRetrofitInterface().downloadFileWithDynamicUrlSync(url);
            response.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                    try {
                        callBack.callBack(response.body());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
