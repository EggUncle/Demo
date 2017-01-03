package com.example.egguncle.demo.myXutils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by egguncle on 17-1-3.
 */


@Target(ElementType.TYPE)// 使用对象：类
@Retention(RetentionPolicy.RUNTIME)// 生命范围：运行期
public @interface MyLayoutInject {
    int value();// 存放布局id
}
