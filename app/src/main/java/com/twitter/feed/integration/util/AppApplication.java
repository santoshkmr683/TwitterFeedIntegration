package com.twitter.feed.integration.util;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //Initializing
        Fresco.initialize(this);
    }
}
