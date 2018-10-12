package com.omfgdevelop.maximtesttask.view.interfaces;

import android.app.Fragment;

import com.omfgdevelop.maximtesttask.view.AbstractFragment;

public interface MainActivityInterface {
    interface View{
        void setFragment(AbstractFragment fragment);
    }
    interface Presenter{
        void getFragment();
    }
}
