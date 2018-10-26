package com.omfgdevelop.maximtesttask.view.interfaces;

public interface FragmentContract {
    interface View {
        void attachPresenter(Presenter presenter);
    }

    interface Presenter {
        void addFragment(AbstractFragment fragment);

    }
}
