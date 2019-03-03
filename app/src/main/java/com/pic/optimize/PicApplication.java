package com.pic.optimize;

import android.app.Application;
import android.content.Context;

public class PicApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    public static String getResString(int resid) {
        return mContext.getString(resid);
    }

}
