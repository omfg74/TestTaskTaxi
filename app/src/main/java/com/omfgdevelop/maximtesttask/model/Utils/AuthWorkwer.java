package com.omfgdevelop.maximtesttask.model.Utils;

import android.content.Context;
import android.widget.Toast;

import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.model.Utils.Network.Requests.AuthRequest;
import com.omfgdevelop.maximtesttask.model.Utils.Network.Requests.EmployeeRequest;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.AuthInterface;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.EmployeeRequestInterface;
import com.omfgdevelop.maximtesttask.model.interfaces.CredentialCheckerInterface;
import com.omfgdevelop.maximtesttask.model.interfaces.SettingsInterface;
import com.omfgdevelop.maximtesttask.view.interfaces.AuthFragmentInterface;

public class AuthWorkwer implements  AuthFragmentInterface.Model {
    CredentialCheckerInterface checked;
    @Override
    public void getAuth(Credentials credentials, Context context) {

        AuthRequest authRequest = new AuthRequest();
        Boolean a = authRequest.getAuth(credentials,context);
        System.out.println(a);
//        AuthInterface authInterface = new AuthRequest();
//        authInterface.getAuth(credentials,context);
//        Log.d("LOG", credentials.getLogin() + " "+ credentials.getPassword());
//        checked= new CredentialsChecker();
//        if(checked.check(credentials, context)){
            //сохраняем авторизацию
//            SettingsInterface settingsInterface = new Settings();
//            settingsInterface.getCredentials();
//            settingsInterface.addCredentials(credentials);
//            Toast.makeText(context,"Seved", Toast.LENGTH_SHORT).show();


            ///Выпилить
//            EmployeeRequestInterface employeeRequestInterface = new EmployeeRequest();
//            employeeRequestInterface.getEmoloyees(credentials,context);
            //
//        }else {
//            Toast.makeText(context,"Failed to save user data", Toast.LENGTH_SHORT).show();
            //не сохраняем
        }

    }

