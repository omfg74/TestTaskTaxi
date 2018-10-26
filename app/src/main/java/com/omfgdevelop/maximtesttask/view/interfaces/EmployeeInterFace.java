package com.omfgdevelop.maximtesttask.view.interfaces;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.omfgdevelop.maximtesttask.model.AbstractEmployee;

public interface EmployeeInterFace {
    interface View {
        void setViews();
        void setText(AbstractEmployee abstractEmployee);
        void setImage(Bitmap bitmap);
        void startNewActivity(Intent intent);
        void setListners();
    }

    interface Model {
        void getImage();

    }

    interface Presenter {
        void onCreate(Bundle bundle);
        void phoneCkicked(String phone);
        void emailClicked(String email);
        void fetchImage(String id, String login, String password);
    }
}
