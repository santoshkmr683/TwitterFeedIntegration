package com.twitter.feed.integration.view;

import com.twitter.feed.integration.model.TwitterTweet;

import java.util.List;

public interface TweetListView extends BaseView {

    void onTweetsSuccess(List<TwitterTweet> twitterTweetList);
}
