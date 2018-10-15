package com.omfgdevelop.maximtesttask.model.Utils;

import android.content.Context;

import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.model.Utils.Network.Requests.AuthRequest;
import com.omfgdevelop.maximtesttask.model.Utils.Network.RetrofitClient;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.AuthInterface;
import com.omfgdevelop.maximtesttask.model.interfaces.CredentialCheckerInterface;
import static android.content.Context.*;
public class CredentialsChecker implements CredentialCheckerInterface {
    @Override
    public boolean check(Credentials credentials, Context context) {
        AuthInterface authInterface = new AuthRequest();
        return authInterface.getAuth(credentials, context);
    }
}
