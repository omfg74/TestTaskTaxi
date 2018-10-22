package com.omfgdevelop.maximtesttask.presenter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import com.omfgdevelop.maximtesttask.model.Emplee.Employee;
import com.omfgdevelop.maximtesttask.model.Utils.Network.Requests.ImageRequest;
import com.omfgdevelop.maximtesttask.view.AbstractFragment;
import com.omfgdevelop.maximtesttask.view.interfaces.EmployeeImageCallBack;
import com.omfgdevelop.maximtesttask.view.interfaces.EmployeeInterFace;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.ResponseBody;

public class EmployeePresenrter implements EmployeeInterFace.Presenter, EmployeeImageCallBack  {

    EmployeeInterFace.View view;
    EmployeeInterFace.Model model;


    public EmployeePresenrter(EmployeeInterFace.View view) {
        this.view = view;

    }


    @Override
    public void phoneCkicked(String phone) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
        view.startNewActivity(callIntent);


    }

    @Override
    public void emailClicked(String email) {
        Intent mailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","",email));
        view.startNewActivity(mailIntent);
    }

    @Override
    public void fetchImage(String id, String login, String password) {


        String url = "https://contact.taxsee.com/Contacts.svc/GetWPhoto?login="+login+"&password="+password+"&id=" +
                id;
        this.model = new ImageRequest(this, this,url);
        model.getImage();
    }


    @Override
    public void callBack(ResponseBody responseBody) {

        int width, height;
        Bitmap bitmap = BitmapFactory.decodeStream(responseBody.byteStream());
        width = bitmap.getWidth()/2;
        height = bitmap.getHeight()/2;

        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap,width,height,false);
        view.setImage(bitmap1);


    }


}
