package com.omfgdevelop.maximtesttask.presenter;

import com.omfgdevelop.maximtesttask.model.AbstractEmployee;
import com.omfgdevelop.maximtesttask.model.Emplee.EmployeeData;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.RecyclerViewCallBackInterface;
import com.omfgdevelop.maximtesttask.view.TreeViewFragmetnInterface;
import com.omfgdevelop.maximtesttask.view.interfaces.MainRecyclerViewFragmentInterface;

public class TreeViewFragmentPresenter implements RecyclerViewCallBackInterface, TreeViewFragmetnInterface.Presenter {

    private TreeViewFragmetnInterface.View view;
    private TreeViewFragmetnInterface.Model.Transfer modelTransfer;
    private TreeViewFragmetnInterface.Model.Request modelRequest;

    public TreeViewFragmentPresenter(TreeViewFragmetnInterface.View view,  TreeViewFragmetnInterface.Model.Request modelRequest) {
        this.view = view;
        this.modelRequest = modelRequest;

    }

    @Override
    public void itemClicked(AbstractEmployee abstractEmployee) {

        view.changeFragment(abstractEmployee);
    }

    public void getData(){
        modelRequest.getEmoloyees(this);
    }

    @Override
    public void callBack(EmployeeData employeeData) {
        view.createTreeView(employeeData);
    }
}
