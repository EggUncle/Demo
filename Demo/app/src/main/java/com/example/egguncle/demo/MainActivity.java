package com.example.egguncle.demo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.egguncle.demo.myXutils.MyLayoutInject;
import com.example.egguncle.demo.myXutils.MyUtils;
import com.example.egguncle.demo.myXutils.MyViewInject;


@MyLayoutInject(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {


    @MyViewInject(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   //     setContentView(R.layout.activity_main);

        MyUtils.inject(this);


        btn.setBackgroundColor(Color.BLUE);

    }
}
