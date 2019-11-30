package com.twitter.feed.integration.event;

import com.twitter.feed.integration.model.TwitterUser;

import java.io.Serializable;

public class ProfileClickEvent extends BaseEvent implements Serializable {

    private TwitterUser twitterUser;

    ProfileClickEvent(TwitterUser twitterUser){
        this.twitterUser = twitterUser;
    }

    public TwitterUser getTwitterUser() {
        return twitterUser;
    }
}
