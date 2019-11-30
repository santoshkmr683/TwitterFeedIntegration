package com.twitter.feed.integration.interactor;

import com.twitter.feed.integration.model.AuthRes;
import com.twitter.feed.integration.model.TwitterTweetRes;
import com.twitter.feed.integration.networkcall.APICallback;
import com.twitter.feed.integration.networkcall.APIServiceUtil;
import com.twitter.feed.integration.util.AppUtil;

import java.util.List;

import retrofit2.Call;

public class TwitterConnectionManager {

    public static void getTwitterAuthToken(APICallback<AuthRes> callback) {

        Call<AuthRes> callObj = APIServiceUtil.getInstance().getApiInterface()
                .getTwitterAuthToken(AppUtil.getAuthTokenHeader(),"client_credentials");
        callObj.enqueue(callback);
    }

    public static void getTwitterTweets(String authToken, APICallback<List<TwitterTweetRes>> callback) {

        Call<List<TwitterTweetRes>> callObj = APIServiceUtil.getInstance().getApiInterface()
                .getTwitterTweetsList(AppUtil.getTweetHeader(authToken));
        callObj.enqueue(callback);
    }
}
