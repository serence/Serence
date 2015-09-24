package org.nganga.sesame;

import android.app.Application;
import android.content.Context;

/**
 * Created by nganga on 9/24/15.
 */
public class MyApp extends Application {

    private static MyApp sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
    }

    public static MyApp getsInstance() {
        return sInstance;
    }


    public static Context getAppContext() {
        return sInstance.getApplicationContext();
    }
}
