package com.omfgdevelop.maximtesttask.model.Utils.Network.Requests;

import com.omfgdevelop.maximtesttask.view.interfaces.EmployeeImageCallBack;
import com.omfgdevelop.maximtesttask.view.interfaces.EmployeeInterFace;

public class ImageRequest implements EmployeeInterFace.Model {
    private EmployeeInterFace.Presenter presenter;
    private EmployeeImageCallBack callBack;

    public ImageRequest(EmployeeInterFace.Presenter presenter, EmployeeImageCallBack callBack) {
        this.presenter = presenter;
        this.callBack = callBack;
    }

    @Override
    public void getImage() {

    }
}
