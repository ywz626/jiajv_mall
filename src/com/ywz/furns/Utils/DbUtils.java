package com.ywz.furns.Utils;

/**
 * @author 于汶泽
 */
public class DbUtils {
    public static int getInt(String key,int de){
        if (key!=null&&key.length()>0) {
            int i = Integer.parseInt(key);
            return i;
        }else {
            return de;
        }
    }
}
