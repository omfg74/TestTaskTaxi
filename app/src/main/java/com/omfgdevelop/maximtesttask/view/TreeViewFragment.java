package com.omfgdevelop.maximtesttask.view;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.omfgdevelop.maximtesttask.MainActivity;
import com.omfgdevelop.maximtesttask.R;
import com.omfgdevelop.maximtesttask.model.AbstractEmployee;
import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.model.Employee.Department;
import com.omfgdevelop.maximtesttask.model.Employee.Employee;
import com.omfgdevelop.maximtesttask.model.Employee.EmployeeData;
import com.omfgdevelop.maximtesttask.model.Employee.Employee_;
import com.omfgdevelop.maximtesttask.model.Employee.Employee__;
import com.omfgdevelop.maximtesttask.model.Employee.Office;
import com.omfgdevelop.maximtesttask.model.Employee.SubDepartment;
import com.omfgdevelop.maximtesttask.model.Utils.Network.Requests.EmployeeRequest;
import com.omfgdevelop.maximtesttask.presenter.TreeViewFragmentPresenter;
import com.omfgdevelop.maximtesttask.view.ViewHolders.DepartmentViewHolder;
import com.omfgdevelop.maximtesttask.view.ViewHolders.EmployeeDaatViewHolder;
import com.omfgdevelop.maximtesttask.view.ViewHolders.EmployeeViewHolder;
import com.omfgdevelop.maximtesttask.view.ViewHolders.Employee_ViewHolder;
import com.omfgdevelop.maximtesttask.view.ViewHolders.Employee__ViewHolder;
import com.omfgdevelop.maximtesttask.view.ViewHolders.OfficeViewHolder;
import com.omfgdevelop.maximtesttask.view.ViewHolders.RootViewHolder;
import com.omfgdevelop.maximtesttask.view.ViewHolders.SubDepartmentViewHolder;
import com.omfgdevelop.maximtesttask.view.interfaces.TreeViewFragmetnInterface;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;

import java.util.ArrayList;
import java.util.List;

public class TreeViewFragment extends Fragment implements  TreeViewFragmetnInterface.View {

    TreeViewFragmetnInterface.Presenter presenter;
    RecyclerView recyclerView;
    EmployeeData employeeData;
    LinearLayout conteiner;
    View view;

    @Override
    public void onResume() {
        super.onResume();
        presenter = new TreeViewFragmentPresenter(this);
        presenter.onCreate();

//        employeeData = new EmployeeData();
//        SharedPreferences sharedPreferences = getContext().getSharedPreferences("settings", Context.MODE_PRIVATE);
//        Credentials credentials = new Credentials();
//        credentials.setLogin(sharedPreferences.getString("Login","lgn"));
//        credentials.setPassword(sharedPreferences.getString("Password","pwd"));
//        EmployeeRequest employeeRequest = new EmployeeRequest(credentials);
//        presenter = new TreeViewFragmentPresenter(this,employeeRequest);
//        ((TreeViewFragmentPresenter) presenter).getData();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.auth_fragment,container,false);
        return view;
    }

//    @Override
//    protected int getLayout() {
//        return R.layout.main_list_fragment;
//    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        conteiner = (LinearLayout)view.findViewById(R.id.containerView);
    }
    @Override
    public void createTreeView(EmployeeData employeeData) {
        TreeNode root = TreeNode.root().setViewHolder(new RootViewHolder(getContext()));
        TreeNode allNode = new TreeNode(employeeData).setViewHolder(new EmployeeDaatViewHolder(getContext()));


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
                                    final Employee__ employee__obj = new Employee__();
                                    employee__obj.setID(employeeData.getOffices().get(i).getDepartments().get(j).getSubDepartments().get(k).getEmployees().get(l).getID());
                                    employee__obj.setName(employeeData.getOffices().get(i).getDepartments().get(j).getSubDepartments().get(k).getEmployees().get(l).getName());
                                    employee__obj.setEmail(employeeData.getOffices().get(i).getDepartments().get(j).getSubDepartments().get(k).getEmployees().get(l).getEmail());
                                    employee__obj.setPhone(employeeData.getOffices().get(i).getDepartments().get(j).getSubDepartments().get(k).getEmployees().get(l).getPhone());
                                    employee__obj.setTitle(employeeData.getOffices().get(i).getDepartments().get(j).getSubDepartments().get(k).getEmployees().get(l).getTitle());
                                    TreeNode subEmployees = new TreeNode(employee__obj).setViewHolder(new Employee__ViewHolder(getContext())).setClickListener(new TreeNode.TreeNodeClickListener() {
                                        @Override
                                        public void onClick(TreeNode node, Object value) {
//                                        Employee__

                                            AbstractEmployee abstractEmployee = new AbstractEmployee();
                                            abstractEmployee.setName(employee__obj.getName());
                                            abstractEmployee.setID(employee__obj.getID());
                                            abstractEmployee.setEmail(employee__obj.getEmail());
                                            abstractEmployee.setPhone(employee__obj.getPhone());
                                            abstractEmployee.setTitle(employee__obj.getTitle());
                                            presenter.itemClicked(abstractEmployee);

                                        }
                                    });
                                    subEmployeeList.add(subEmployees);
                                }
                            }else {

                            }
                            subDepartmentsList.add(subDepartment);
                            subDepartment.addChildren(subEmployeeList);
                        }
                    }else if(employeeData.getOffices().get(i).getDepartments().get(j).getEmployees()!=null){

                        for (int k = 0; k<employeeData.getOffices().get(i).getDepartments().get(j).getEmployees().size(); k++){
                            final Employee_ employee_ = new Employee_();
                            employee_.setName(employeeData.getOffices().get(i).getDepartments().get(j).getEmployees().get(k).getName());
                            employee_.setID(employeeData.getOffices().get(i).getDepartments().get(j).getEmployees().get(k).getID());
                            employee_.setEmail(employeeData.getOffices().get(i).getDepartments().get(j).getEmployees().get(k).getEmail());
                            employee_.setTitle(employeeData.getOffices().get(i).getDepartments().get(j).getEmployees().get(k).getTitle());
                            employee_.setPhone(employeeData.getOffices().get(i).getDepartments().get(j).getEmployees().get(k).getPhone());
                            TreeNode employeeTreeNode = new TreeNode(employee_).setViewHolder(new Employee_ViewHolder(getContext())).setClickListener(new TreeNode.TreeNodeClickListener() {
                                @Override
                                public void onClick(TreeNode node, Object value) {

                                    AbstractEmployee abstractEmployee = new AbstractEmployee();
                                    abstractEmployee.setName(employee_.getName());
                                    abstractEmployee.setID(employee_.getID());
                                    abstractEmployee.setEmail(employee_.getEmail());
                                    abstractEmployee.setPhone(employee_.getPhone());
                                    abstractEmployee.setTitle(employee_.getTitle());
                                    presenter.itemClicked(abstractEmployee);

                                }
                            });
                            subDepartmentsList.add(employeeTreeNode);
                        }
                    }
                    departmentsList.add(department);
                    department.addChildren(subDepartmentsList);
                }

            }else if(employeeData.getOffices().get(i).getEmployees()!=null){
                //add employee treenode offices
                for (int j = 0; j <employeeData.getOffices().get(i).getEmployees().size() ; j++) {
                    final Employee employee = new Employee();
                    employee.setID(employeeData.getOffices().get(i).getEmployees().get(j).getID());
                    employee.setName(employeeData.getOffices().get(i).getEmployees().get(j).getName());
                    employee.setEmail(employeeData.getOffices().get(i).getEmployees().get(j).getEmail());
                    employee.setTitle(employeeData.getOffices().get(i).getEmployees().get(j).getTitle());
                    employee.setPhone(employeeData.getOffices().get(i).getEmployees().get(j).getPhone());
                    TreeNode officeEmployee = new TreeNode(employee).setViewHolder(new EmployeeViewHolder(getContext())).setClickListener(new TreeNode.TreeNodeClickListener() {
                        @Override
                        public void onClick(TreeNode node, Object value) {
                            //Employee

                            AbstractEmployee abstractEmployee = new AbstractEmployee();
                            abstractEmployee.setName(employee.getName());
                            abstractEmployee.setID(employee.getID());
                            abstractEmployee.setEmail(employee.getEmail());
                            abstractEmployee.setPhone(employee.getPhone());
                            abstractEmployee.setTitle(employee.getTitle());
                            presenter.itemClicked(abstractEmployee);

                        }
                    });
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

    @Override
    public void attachFragmentToContainer(AbstractEmployee abstractEmployee) {
                Bundle bundle = new Bundle();
        bundle.putSerializable("employee",abstractEmployee);
        EmployeeFragment employeeFragment = new EmployeeFragment();
        employeeFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.main_fragment_place,employeeFragment)
                .commit();
    }
}
//
//    @Override
//    public void changeFragment(AbstractEmployee abstractEmployee) {
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("employee",abstractEmployee);
//        AbstractFragment fragment = new EmployeeFragment();
//        fragment .setArguments(bundle);
//        controllerPresenter.addFragment(fragment);

//    private SharedPreferences initTransfer(){
//        SharedPreferences trPrefs = getContext().getSharedPreferences("transfer", Context.MODE_PRIVATE);
//        return trPrefs;

//    }

//}
