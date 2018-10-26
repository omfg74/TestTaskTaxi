package com.omfgdevelop.maximtesttask.view.interfaces;

import com.omfgdevelop.maximtesttask.model.Credentials;


public interface AuthFragmentInterface {
    interface View {
        void attachFragmentToContainer();

        String getLogin();

        String getPassword();

        void setElements();

        void setButton();

        //        void changeFragment();
        void setText(String str);

        void setTestText();
    }

    interface Presenter {
        void onCreate();

        void buttonClicked();

        void checkSettings();
//        void deleteSettings();
    }

    interface Model {
        interface Settings {
            void initEditor();

            void addCredentials(Credentials credentials);

            void delCredentials();

            Credentials getCredentials();

            boolean checkIfExists();
        }
    }
}
