package com.omfgdevelop.maximtesttask.model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.omfgdevelop.maximtesttask.model.Utils.CredentialsChecker;
import com.omfgdevelop.maximtesttask.model.Utils.Network.Requests.AuthRequest;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.AuthInterface;
import com.omfgdevelop.maximtesttask.model.Utils.Settings;
import com.omfgdevelop.maximtesttask.model.interfaces.CredentialCheckerInterface;
import com.omfgdevelop.maximtesttask.model.interfaces.SettingsInterface;
import com.omfgdevelop.maximtesttask.view.interfaces.AuthFragmentInterface;

import java.io.Serializable;

public class Credentials implements Serializable {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
