package com.omfgdevelop.maximtesttask.view.interfaces;

import java.io.IOException;

import okhttp3.ResponseBody;

public interface EmployeeImageCallBack {
    void callBack(ResponseBody responseBody) throws IOException;
}
