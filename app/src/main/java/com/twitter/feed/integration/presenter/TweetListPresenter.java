package com.twitter.feed.integration.presenter;

import android.content.Context;

import com.twitter.feed.integration.R;
import com.twitter.feed.integration.interactor.TwitterConnectionManager;
import com.twitter.feed.integration.model.TwitterTweetRes;
import com.twitter.feed.integration.networkcall.APICallback;
import com.twitter.feed.integration.util.AppUtil;
import com.twitter.feed.integration.view.BaseView;
import com.twitter.feed.integration.view.TweetListView;

import java.util.List;

public class TweetListPresenter extends BasePresenter {

    public TweetListPresenter(BaseView view) {
        super(view);
    }

    public void getAuthTokenCall(Context context, String authToken, String screenName) {

        if (!AppUtil.isNetworkAvailable(context)) {
            showNetworkAlert();
            return;
        }
        String finalUrl = context.getString(R.string.user_time_lines) + screenName;
        showProgressBar();
        TwitterConnectionManager.getTwitterTweets(finalUrl, authToken, new APICallback<List<TwitterTweetRes>>() {

            @Override
            public void onResponseSuccess(List<TwitterTweetRes> response) {

                TweetListView view = (TweetListView) getView();
                if (view == null) {
                    return;
                }
                view.onTweetsSuccess(response);
            }

            @Override
            public void onResponseFailure(String errorMessage) {
                handleError(errorMessage);
            }
        });
    }
}
