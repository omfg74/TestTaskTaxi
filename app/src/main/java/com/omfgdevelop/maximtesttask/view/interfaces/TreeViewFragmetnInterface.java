package com.omfgdevelop.maximtesttask.view.interfaces;

import android.content.Context;

import com.omfgdevelop.maximtesttask.model.AbstractEmployee;
import com.omfgdevelop.maximtesttask.model.Employee.EmployeeData;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.RecyclerViewCallBackInterface;

public interface TreeViewFragmetnInterface {
    interface View{
        void createTreeView(EmployeeData employeeData);
        void changeFragment(AbstractEmployee abstractEmployee);
        Context getContext();

    }
     interface Presenter{
        void itemClicked(AbstractEmployee abstractEmployee);
    }
     interface Model {
        interface Transfer{
            public void initEditor();
            public void addEmployee(AbstractEmployee employee);
            public AbstractEmployee getEmpoloyee();

        }

        interface Request {

            void getEmoloyees(RecyclerViewCallBackInterface callback);
        }
    }
}
