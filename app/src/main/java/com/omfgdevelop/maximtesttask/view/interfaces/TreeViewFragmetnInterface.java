package com.omfgdevelop.maximtesttask.view.interfaces;

import com.omfgdevelop.maximtesttask.model.AbstractEmployee;
import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.model.Employee.EmployeeData;
import com.omfgdevelop.maximtesttask.Utils.Network.interfaces.RecyclerViewCallBackInterface;

public interface TreeViewFragmetnInterface {
    interface View {
        void createTreeView(EmployeeData employeeData);

        void attachFragmentToContainer(AbstractEmployee abstractEmployee);
    }

    interface Presenter {
        void onCreate();

        void getSavedData();

        void itemClicked(AbstractEmployee abstractEmployee);
    }

    interface Model {
        interface Request {
            void getEmoloyees(RecyclerViewCallBackInterface callback, Credentials credentials);
        }
    }
}
