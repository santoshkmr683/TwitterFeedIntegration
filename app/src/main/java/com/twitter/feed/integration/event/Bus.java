package com.twitter.feed.integration.event;


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

}
