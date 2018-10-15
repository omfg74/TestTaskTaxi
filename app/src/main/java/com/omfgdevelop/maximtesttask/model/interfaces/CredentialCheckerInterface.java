package com.omfgdevelop.maximtesttask.model.interfaces;

import android.content.Context;

import com.omfgdevelop.maximtesttask.model.Credentials;

public interface CredentialCheckerInterface {
    boolean check(Credentials credentials, Context context);
}
