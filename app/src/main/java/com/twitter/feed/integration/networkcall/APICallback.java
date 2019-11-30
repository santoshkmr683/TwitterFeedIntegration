package com.twitter.feed.integration.networkcall;

import android.util.Log;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class APICallback<T> implements Callback<T> {

    protected APICallback() {

    }

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {

        if (response.isSuccessful()) {
            onResponseSuccess(response.body());
        } else if (response.code() == 401 || response.code() == 403) {
            // Expired or invalid auth token. Redirect user to login again.
            Log.d("TAG", "CAME TO ERROR" + response.raw().request().url().toString());
        } else {
            onResponseFailure(response.message());
        }
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        onResponseFailure(t.getMessage());
    }

    public abstract void onResponseSuccess(T response);

    public abstract void onResponseFailure(String errorMessage);
}
