package com.twitter.feed.integration.view;

import com.twitter.feed.integration.model.AuthRes;

public interface AuthTokenView extends BaseView {

    void onAuthTokenSuccess(AuthRes authRes);
}
