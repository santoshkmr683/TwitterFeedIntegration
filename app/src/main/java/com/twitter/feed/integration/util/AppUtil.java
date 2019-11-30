package com.twitter.feed.integration.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public class AppUtil {

    public static HashMap<String, String> getAuthTokenHeader() {
        HashMap<String, String> header = new HashMap<>();
        header.put("Authorization", "Basic " + twitterKeyBase64());
        header.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        return header;
    }

    public static HashMap<String, String> getTweetHeader(String authToken){

        HashMap<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer " + authToken);
        header.put("Content-Type", "application/json");
        return header;
    }

    private static String twitterKeyBase64() {
        String twitterUrlApiKey = null;
        String twitterUrlApiSecret = null;
        try {
            twitterUrlApiKey = URLEncoder.encode(Constant.TWITTER_API_KEY, "UTF-8");
            twitterUrlApiSecret = URLEncoder.encode(Constant.TWITTER_API_SECRET, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String twitterKeySecret = twitterUrlApiKey + ":" + twitterUrlApiSecret;
        return Base64.encodeToString(twitterKeySecret.getBytes(), Base64.NO_WRAP);
    }


    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = null;

        if (connectivityManager != null) {
            activeNetworkInfo = connectivityManager
                    .getActiveNetworkInfo();
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static String getWordWhichStartFromHttps(String sourceString) {

        String[] strArray = sourceString.split(" ");
        String httpString = null;
        for (String s : strArray) {
            if (s.contains("https")) {
                httpString = s;
            }
        }
        return httpString;
    }
}
