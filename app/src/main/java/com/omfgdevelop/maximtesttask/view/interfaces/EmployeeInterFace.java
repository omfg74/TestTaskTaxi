package com.omfgdevelop.maximtesttask.view.interfaces;

public  interface EmployeeInterFace {
    interface View{
        void setImage();
        void setText();
    }
    interface Model{
        void getImage();

    }
    interface Presenter{
        void phoneCkicked();
        void emailClicked();
    }
}
