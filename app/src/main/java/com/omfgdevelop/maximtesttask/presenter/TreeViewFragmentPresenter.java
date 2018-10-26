package com.omfgdevelop.maximtesttask.presenter;

import android.content.Context;

import com.omfgdevelop.maximtesttask.ContentProvider;
import com.omfgdevelop.maximtesttask.model.AbstractEmployee;
import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.model.Employee.EmployeeData;
import com.omfgdevelop.maximtesttask.model.Utils.Network.Requests.EmployeeRequest;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.RecyclerViewCallBackInterface;
import com.omfgdevelop.maximtesttask.model.Utils.Settings;
import com.omfgdevelop.maximtesttask.view.interfaces.TreeViewFragmetnInterface;

public class TreeViewFragmentPresenter implements RecyclerViewCallBackInterface, TreeViewFragmetnInterface.Presenter {

    private TreeViewFragmetnInterface.View view;
    private TreeViewFragmetnInterface.Model.Request modelRequest;
    private Credentials credentials;

    public TreeViewFragmentPresenter(TreeViewFragmetnInterface.View view) {
        this.view = view;
        this.modelRequest = new EmployeeRequest();

    }

    @Override
    public void onCreate() {
        getSavedData();
        getData();
    }

    @Override
    public void getSavedData() {
        Settings settings = new Settings(ContentProvider.getContext().getSharedPreferences(Settings.STORAGE_NAME, Context.MODE_PRIVATE));
        this.credentials = settings.getCredentials();
    }

    @Override
    public void itemClicked(AbstractEmployee abstractEmployee) {
        view.attachFragmentToContainer(abstractEmployee);
    }

    public void getData() {
        modelRequest.getEmoloyees(this, this.credentials);
    }

    @Override
    public void callBack(EmployeeData employeeData) {
        view.createTreeView(employeeData);
    }
}
