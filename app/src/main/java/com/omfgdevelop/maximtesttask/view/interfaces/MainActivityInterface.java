package com.omfgdevelop.maximtesttask.view.interfaces;

public interface MainActivityInterface {
    interface View {
        //        void setFragment(AbstractFragment fragment);
        void setFabListner();

        void attachFragmentToContainer();
    }

    interface Presenter {
        void onCreate();

        void deleteSettings();
//        void getFragment();
    }

}
