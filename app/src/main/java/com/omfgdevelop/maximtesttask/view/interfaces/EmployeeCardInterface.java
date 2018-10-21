package com.omfgdevelop.maximtesttask.view.interfaces;

public interface EmployeeCardInterface {
    interface View{
       void setImage();
    }
    interface Model{
        void getImage();

    }
    interface presenter{
       void phoneCkicked();
       void emailClicked();
    }
}
