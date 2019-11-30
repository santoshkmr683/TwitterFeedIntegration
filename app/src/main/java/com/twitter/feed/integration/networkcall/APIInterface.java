package com.twitter.feed.integration.networkcall;

import com.twitter.feed.integration.model.AuthRes;
import com.twitter.feed.integration.model.TwitterTweetRes;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface APIInterface {

    @POST("oauth2/token")
    @FormUrlEncoded
    Call<AuthRes> getTwitterAuthToken(@HeaderMap Map<String, String> headers,
                                      @Field("grant_type") String grantType);

    @GET
    Call<List<TwitterTweetRes>> getTwitterTweetsList(@Url String url, @HeaderMap Map<String, String> headers);
}
