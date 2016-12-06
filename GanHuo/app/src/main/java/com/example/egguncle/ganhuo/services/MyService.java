package com.example.egguncle.ganhuo.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.egguncle.ganhuo.MyApplication;
import com.example.egguncle.ganhuo.entries.GanHuoInfo;
import com.google.gson.Gson;

public class MyService extends Service {

    private MyBinder mBinder=new MyBinder();

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        return mBinder;
    }

    public class MyBinder extends Binder {

        public  void getInfo(String url) {
            StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.v("MY_TAG",response);
                    GanHuoInfo info = new Gson().fromJson(response,GanHuoInfo.class);
                    Log.v("MY_TAG",info.getResults().get(0).getDesc());
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

            request.setTag("newGet");
            MyApplication.getHttpQueues().add(request);
        }

    }
}
