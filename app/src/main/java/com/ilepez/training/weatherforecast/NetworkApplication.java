package com.ilepez.training.weatherforecast;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.ilepez.training.weatherforecast.network.LruBitmapCache;

import java.lang.Override;

/**
 * Created by student5304 on 08/03/16.
 */
public class NetworkApplication extends Application {

    private static NetworkApplication sharedInstance;

    private RequestQueue volleyRequestQueue;
    private ImageLoader volleyImageLoader;

    @Override
    public void onCreate() {
        super.onCreate();

        NetworkApplication.sharedInstance = this;

        volleyRequestQueue = Volley.newRequestQueue(this);
        volleyImageLoader = new ImageLoader(volleyRequestQueue, new LruBitmapCache(1024));

        volleyRequestQueue.start();

    }

    public static NetworkApplication getSharedInstance() {
        return sharedInstance;
    }

    public ImageLoader getVolleyImageLoader() {
        return volleyImageLoader;
    }

    public RequestQueue getVolleyRequestQueue() {
        return volleyRequestQueue;
    }
}
