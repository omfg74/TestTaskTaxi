package com.omfgdevelop.maximtesttask.view.interfaces;

import android.graphics.Bitmap;

public  interface EmployeeInterFace {
    interface View{
        void setImage(Bitmap bitmap);
        void setText();
    }
    interface Model{
        void getImage();

    }
    interface Presenter{
        void phoneCkicked();
        void emailClicked();
        void fetchImage(String id, String login, String password);
    }
}
