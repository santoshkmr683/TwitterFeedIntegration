package com.twitter.feed.integration.event;


import com.twitter.feed.integration.model.TwitterUser;

import org.greenrobot.eventbus.EventBus;

public final class Bus {
    private Bus() {

    }

    public static void register(Object object) {
        EventBus.getDefault().register(object);
    }

    public static void unregister(Object object) {
        EventBus.getDefault().unregister(object);
    }

    private static void post(BaseEvent baseEvent) {
        EventBus.getDefault().post(baseEvent);
    }

    public static void postClickOnUrlEvent(String url) {
        post(new UrlEvent(url));
    }

    public static void postProfileClickEvent(TwitterUser twitterUser) {
        post(new ProfileClickEvent(twitterUser));
    }

}
