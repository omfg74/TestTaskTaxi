package com.omfgdevelop.maximtesttask;

import android.app.Application;
import android.content.Context;

public class ContentProvider extends Application {
    private static Context context;

    public void onCreate(){
        super.onCreate();
        ContentProvider.context = getApplicationContext();
    }
    public static Context getContext(){
        return ContentProvider.context;
    }
}
