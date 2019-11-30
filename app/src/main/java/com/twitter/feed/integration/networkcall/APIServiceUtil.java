package com.twitter.feed.integration.networkcall;

import com.twitter.feed.integration.BuildConfig;
import com.twitter.feed.integration.util.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIServiceUtil {

    private static APIServiceUtil sInstance;
    private final Retrofit mRetrofit;

    private APIServiceUtil() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClientBuilder().build())
                .build();
    }

    public static synchronized APIServiceUtil getInstance() {
        if (sInstance == null) {
            sInstance = new APIServiceUtil();
        }
        return sInstance;
    }

    private OkHttpClient.Builder getOkHttpClientBuilder() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging)
                .readTimeout(100, TimeUnit.SECONDS)
                .connectTimeout(100, TimeUnit.SECONDS);
        return httpClient;
    }

    public APIInterface getApiInterface() {
        return mRetrofit.create(APIInterface.class);
    }
}
