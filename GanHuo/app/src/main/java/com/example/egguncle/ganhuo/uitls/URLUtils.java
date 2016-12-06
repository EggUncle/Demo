package com.example.egguncle.ganhuo.uitls;

/**
 * Created by egguncle on 16-12-5.
 */

public class URLUtils {
    public final static String S_URL="http://gank.io/api/data/";

    public final static String S_ANDROID="Android";
    public final static String S_IOS="iOS";
    public final static String S_HTML="前端";
    public final static String S_GIRL="福利";
    public final static String S_OTHER="拓展资源";

    public static String getMyUrl(String type,int page){
        return S_URL+type+"/"+"10"+"/"+page;
    }
}
