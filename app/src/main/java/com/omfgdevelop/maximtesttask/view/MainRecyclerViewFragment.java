package com.omfgdevelop.maximtesttask.view;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.omfgdevelop.maximtesttask.MainRecyclerViewAdapter;
import com.omfgdevelop.maximtesttask.R;
import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.model.Emplee.EmployeeData;
import com.omfgdevelop.maximtesttask.model.Utils.Network.Requests.EmployeeRequest;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.EmployeeRequestInterface;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.RecyclerViewCallBackInterface;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclerViewFragment extends AbstractFragment implements RecyclerViewCallBackInterface {

    RecyclerView recyclerView;
    MainRecyclerViewAdapter adapter;
    EmployeeData employeeData;
    FrameLayout conteiner;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        employeeData = new EmployeeData();
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("settings", Context.MODE_PRIVATE);
        Credentials credentials = new Credentials();
        credentials.setLogin(sharedPreferences.getString("Login","lgn"));
        credentials.setPassword(sharedPreferences.getString("Password","pwd"));
        EmployeeRequestInterface employeeRequestInterface = new EmployeeRequest(credentials,employeeData,this);
        employeeRequestInterface.getEmoloyees();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      return   super.onCreateView(inflater, container, savedInstanceState);
//    View view = inflater.inflate(R.layout.main_list_fragment,container,false);
//
//    return view;
    }

    @Override
    protected int getLayout() {
        return R.layout.main_list_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        conteiner = (FrameLayout)view.findViewById(R.id.containerView);

    }

    @Override
    public void callBack(EmployeeData employeeData) {

//        recyclerView = view.findViewById(R.id.mainRecyclerView);
//        adapter = new MainRecyclerViewAdapter(employeeData);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(adapter);
//        recyclerView.setHasFixedSize(true);

        System.out.println(employeeData.getOffices());
        for (int i = 0; i <employeeData.getOffices().size() ; i++) {
            System.out.println(employeeData.getOffices().get(i).getName());
            if (employeeData.getOffices().get(i).getDepartments() != null) {
                for (int j = 0; j <employeeData.getOffices().get(i).getDepartments().size(); j++) {
                    System.out.println(employeeData.getOffices().get(i).getDepartments().get(j).getName());
                    if(employeeData.getOffices().get(i).getDepartments().get(j).getSubDepartments()!=null){
                        for (int k = 0; k <employeeData.getOffices().get(i).getDepartments().get(j).getSubDepartments().size() ; k++) {
                            System.out.println(employeeData.getOffices().get(i).getDepartments().get(j).getSubDepartments().get(k).getName());
                        }
                    }
                }
            }
        }

        //Tree view

        TreeNode root = TreeNode.root();
        //24 29
        TreeNode mainNode = new TreeNode(employeeData.getName());
        List<TreeNode> officesList = new ArrayList<>();
        List<TreeNode> departmentsList = new ArrayList<>();
        for (int i = 0; i <employeeData.getOffices().size() ; i++) {
            TreeNode office = new TreeNode(employeeData.getOffices().get(i).getName());
            officesList.add(office);
            if (employeeData.getOffices().get(i).getDepartments()!=null){
            for (int j = 0; j <employeeData.getOffices().get(i).getDepartments().size() ; j++) {
                TreeNode department = new TreeNode(employeeData.getOffices().get(i).getDepartments().get(j).getName());
            }}
        }

//        mainNode.addChild(officesList.get(i).)
        mainNode.addChildren(officesList);
        root.addChild(mainNode);
        AndroidTreeView treeView = new AndroidTreeView(getContext(), root);
        conteiner.addView(treeView.getView());


    }
}
