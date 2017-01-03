package com.example.egguncle.demo.myXutils;

import android.content.Context;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by egguncle on 17-1-3.
 */

public class MyUtils {


    public static void inject(Context context){
        myLayoutInject(context);
        myViewInject(context);
    }

    private static void myViewInject(Context context) {
        try {
            Class<? extends Context> uiClass = context.getClass();

            Field[] fields = uiClass.getDeclaredFields();
            for (Field f : fields) {
                MyViewInject annotation = f.getAnnotation(MyViewInject.class);

                if (annotation != null) {
                    int value = annotation.value();
                    Method findViewById = uiClass.getMethod("findViewById", int.class);
                    Object invoke = findViewById.invoke(context, value);

                    //设置允许访问
                    f.setAccessible(true);
                    f.set(context, invoke);
                }
            }
        } catch (Exception e) {

        }
    }

    private static void myLayoutInject(Context context) {
        try {
            Class<? extends Context> uiClass = context.getClass();

            MyLayoutInject annotation = uiClass.getAnnotation(MyLayoutInject.class);
            if (annotation != null) {
                int value = annotation.value();
                Method setContentView = uiClass.getMethod("setContentView", int.class);
                setContentView.invoke(context,value);
            }
        } catch (Exception e) {

        }

    }
}
