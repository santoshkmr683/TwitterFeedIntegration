package com.twitter.feed.integration.view;

import com.twitter.feed.integration.model.TwitterTweetRes;

import java.util.List;

public interface TweetListView extends BaseView {

    void onTweetsSuccess(List<TwitterTweetRes> twitterTweetList);
}
