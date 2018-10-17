package com.omfgdevelop.maximtesttask.view.interfaces;

import com.omfgdevelop.maximtesttask.view.AbstractFragment;

public interface FragmentContract {
    interface View{
        void attachPresenter(Presenter presenter);
    }

    interface Presenter{
        void addFragment(AbstractFragment fragment);

    }
}
