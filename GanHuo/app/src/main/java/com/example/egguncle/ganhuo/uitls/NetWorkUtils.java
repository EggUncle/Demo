package com.example.egguncle.ganhuo.uitls;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.egguncle.ganhuo.MyApplication;
import com.example.egguncle.ganhuo.entries.GanHuoInfo;
import com.google.gson.Gson;

/**
 * Created by egguncle on 16-12-5.
 */

public class NetWorkUtils {


    public static void getInfo(String url) {
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
