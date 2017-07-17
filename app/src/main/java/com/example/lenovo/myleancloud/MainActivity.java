package com.example.lenovo.myleancloud;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.SaveCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        AVObject product = new AVObject("Product");
//        product.put("title","sssssss");
//        product.put("description","asdf");
//        product.put("owner",AVUser.getCurrentUser());
//        product.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(AVException e) {
//                if(e==null){
//                    Toast.makeText(MainActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        AVQuery<AVObject> product = new AVQuery<AVObject>("Product");
        product.include("owner");
        product.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                AVObject avObject = list.get(0);
                String description = (String)avObject.get("description");
                AVUser owner = avObject.getAVUser("owner");
                String username = owner.getUsername();

            }
        });
    }
}
