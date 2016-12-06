package com.example.egguncle.ganhuo;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by egguncle on 16-12-5.
 */

public class MyApplication extends Application {

    private static RequestQueue queues;


    @Override
    public void onCreate() {
        super.onCreate();
        queues = Volley.newRequestQueue(getApplicationContext());
        //     createDB();


    }

    public static RequestQueue getHttpQueues() {
        return queues;
    }



}
