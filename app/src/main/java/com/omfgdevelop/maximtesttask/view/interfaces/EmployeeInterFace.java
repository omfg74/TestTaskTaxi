package com.omfgdevelop.maximtesttask.view.interfaces;

import android.content.Intent;
import android.graphics.Bitmap;

public  interface EmployeeInterFace {
    interface View{
        void setImage(Bitmap bitmap);
        void startNewActivity(Intent intent);
    }
    interface Model{
        void getImage();

    }
    interface Presenter{
        void phoneCkicked(String phone  );
        void emailClicked(String email);
        void fetchImage(String id, String login, String password);
    }
}
