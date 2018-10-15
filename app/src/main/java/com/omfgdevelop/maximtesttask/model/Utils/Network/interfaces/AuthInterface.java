package com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces;

import android.content.Context;

import com.omfgdevelop.maximtesttask.model.Credentials;

public interface AuthInterface {
    boolean getAuth(Credentials credentials, Context context);
}
