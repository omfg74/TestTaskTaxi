package com.omfgdevelop.maximtesttask.view;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.omfgdevelop.maximtesttask.R;
import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.model.Emplee.Department;
import com.omfgdevelop.maximtesttask.model.Emplee.Employee;
import com.omfgdevelop.maximtesttask.model.Emplee.EmployeeData;
import com.omfgdevelop.maximtesttask.model.Emplee.Employee_;
import com.omfgdevelop.maximtesttask.model.Emplee.Office;
import com.omfgdevelop.maximtesttask.model.Emplee.SubDepartment;
import com.omfgdevelop.maximtesttask.model.Utils.Network.Requests.EmployeeRequest;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.EmployeeRequestInterface;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.RecyclerViewCallBackInterface;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclerViewFragment extends AbstractFragment implements RecyclerViewCallBackInterface {

    RecyclerView recyclerView;
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

        TreeNode root = TreeNode.root();

        TreeNode allNode = new TreeNode(employeeData.getName());

        List<TreeNode> officesList = new ArrayList<>();


        for (int i = 0; i <employeeData.getOffices().size() ; i++) {
            Office officeObj = new Office();
            officeObj.setName(employeeData.getOffices().get(i).getName());
            officeObj.setID(employeeData.getOffices().get(i).getID());
            TreeNode office = new TreeNode(officeObj).setViewHolder(new OfficeViewHolder(getContext()));
            List<TreeNode> departmentsList = new ArrayList<>();
            if (employeeData.getOffices().get(i).getDepartments()!=null){
            for (int j = 0; j <employeeData.getOffices().get(i).getDepartments().size() ; j++) {
                Department departmentObj = new Department();
                departmentObj.setName(employeeData.getOffices().get(i).getDepartments().get(j).getName());
                departmentObj.setID(employeeData.getOffices().get(i).getDepartments().get(j).getID());
                TreeNode department = new TreeNode(departmentObj).setViewHolder(new DepartmentViewHolder(getContext()));
                if(employeeData.getOffices().get(i).getDepartments().get(j).getEmployees()!=null){
                Employee employee_ = new Employee();
                TreeNode employeeTreeNode = new TreeNode(employee_).setViewHolder(new EmployeeViewHolder(getContext()));
                departmentsList.add(employeeTreeNode);
                }
                List<TreeNode> subDepartmentsList = new ArrayList<>();
                if(employeeData.getOffices().get(i).getDepartments().get(j).getSubDepartments()!=null){
                    for (int k = 0; k <employeeData.getOffices().get(i).getDepartments().get(j).getSubDepartments().size() ; k++) {
                        SubDepartment subDepartmentObj = new SubDepartment();
                        subDepartmentObj.setName(employeeData.getOffices().get(i).getDepartments().get(j).getSubDepartments().get(k).getName());
                        subDepartmentObj.setID(employeeData.getOffices().get(i).getDepartments().get(j).getSubDepartments().get(k).getID());
                        TreeNode subDepartment = new TreeNode(subDepartmentObj).setViewHolder(new SubDepartmentViewHolder(getContext()));

                        List<TreeNode>subEmployeeList = new ArrayList<>();
                        if(employeeData.getOffices().get(i).getDepartments().get(j).getSubDepartments().get(k).getEmployees()!=null){
                            //add employee tree node
                            for (int l = 0; l <employeeData.getOffices().get(i).getDepartments().get(j).getSubDepartments().get(k).getEmployees().size(); l++) {

                                TreeNode subEmployees = new TreeNode(employeeData.getOffices().get(i).getDepartments().get(j).getSubDepartments().get(k).getEmployees().get(l).getName());
                                subEmployeeList.add(subEmployees);
                            }
                        }else {

                        }
                        subDepartmentsList.add(subDepartment);
                        subDepartment.addChildren(subEmployeeList);
                    }
                }else{

                }
                departmentsList.add(department);
                department.addChildren(subDepartmentsList);
            }

            }else if(employeeData.getOffices().get(i).getEmployees()!=null){
                //add employee treenode offices
                for (int j = 0; j <employeeData.getOffices().get(i).getEmployees().size() ; j++) {
                    Employee employee = new Employee();
                    TreeNode officeEmployee = new TreeNode(employeeData.getOffices().get(i).getEmployees().get(j).getName());
                    departmentsList.add(officeEmployee);
                }
            }
            office.addChildren(departmentsList);
            officesList.add(office);
        }

//        mainNode.addChild(officesList.get(i).)


        allNode.addChildren(officesList);
        root.addChild(allNode);
        AndroidTreeView treeView = new AndroidTreeView(getContext(), root);
        conteiner.addView(treeView.getView());


    }
}
