package com.omfgdevelop.maximtesttask.model.Utils;

import android.content.Context;

import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.model.Utils.Network.Requests.AuthRequestRequest;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.AuthRequestInterface;
import com.omfgdevelop.maximtesttask.model.interfaces.CredentialCheckerInterface;

public class CredentialsChecker implements CredentialCheckerInterface {
    @Override
    public boolean check(Credentials credentials, Context context) {
        AuthRequestInterface authRequestInterface = new AuthRequestRequest();
        return authRequestInterface.getAuth(credentials, context);
    }
}
