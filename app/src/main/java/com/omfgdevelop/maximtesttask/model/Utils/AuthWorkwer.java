package com.omfgdevelop.maximtesttask.model.Utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.omfgdevelop.maximtesttask.model.AuthData;
import com.omfgdevelop.maximtesttask.model.Credentials;
import com.omfgdevelop.maximtesttask.model.Utils.Network.Requests.AuthRequest;
import com.omfgdevelop.maximtesttask.model.Utils.Network.Requests.EmployeeRequest;
import com.omfgdevelop.maximtesttask.model.Utils.Network.RetrofitClient;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.AuthInterface;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.EmployeeRequestInterface;
import com.omfgdevelop.maximtesttask.model.Utils.Network.interfaces.RetrofitInterface;
import com.omfgdevelop.maximtesttask.model.interfaces.CredentialCheckerInterface;
import com.omfgdevelop.maximtesttask.model.interfaces.SettingsInterface;
import com.omfgdevelop.maximtesttask.view.AuthFragment;
import com.omfgdevelop.maximtesttask.view.interfaces.AuthFragmentInterface;

public class AuthWorkwer implements AuthFragmentInterface.Model {
//    CredentialCheckerInterface checked;

//    public boolean getAuth(Credentials credentials, Context context) {

    static Credentials credentials;
     static Context context;

    public AuthWorkwer(Credentials credentials, Context context)  {
    this.credentials = credentials;
    this.context = context;

    }

    public static void getAuth(AuthInterface callback) {

        AuthRequest authRequest = new AuthRequest();

        callback.authResult(authRequest.getAuthResponse(credentials,context));

//здесь ревлизрвть шареды и проверку на из наоичие

//        Log.d("LOG", credentials.getLogin() + " "+ credentials.getPassword());
//        checked= new CredentialsChecker();
//        if(checked.check(credentials, context)){
//Проверяем есть ли сохраненные данные
//            SettingsInterface settingsInterface = new Settings();
//            settingsInterface.getPreferences();
//            if(settingsInterface.checkIfExists()) {
//                            сохраняем авторизацию
//                settingsInterface.addCredentials(credentials);
//                Toast.makeText(context, "Seved", Toast.LENGTH_SHORT).show();
//Log.d("log","saved");
//            }else {
////                Toast.makeText(context, "Hello again", Toast.LENGTH_SHORT).show();
//                Log.d("log","saved");
//            }
//
//            return true;
//
//        }else {
////            Toast.makeText(context,"Failed to save user data", Toast.LENGTH_SHORT).show();
////            не сохраняем
//            Log.d("log","saved");
//        }
//        return false;
//
//    }

    }
}

