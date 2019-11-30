package com.twitter.feed.integration.event;

public class UrlEvent extends BaseEvent {

    private String url;

    UrlEvent(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
