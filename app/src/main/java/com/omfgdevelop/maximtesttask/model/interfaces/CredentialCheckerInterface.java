package com.omfgdevelop.maximtesttask.model.interfaces;

import android.content.Context;

import com.omfgdevelop.maximtesttask.model.AuthData;
import com.omfgdevelop.maximtesttask.model.Credentials;

public interface CredentialCheckerInterface {
    void check(Credentials credentials, Context context);
}
