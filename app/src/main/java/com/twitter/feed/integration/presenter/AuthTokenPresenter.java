package com.twitter.feed.integration.presenter;

import android.content.Context;

import com.twitter.feed.integration.interactor.TwitterConnectionManager;
import com.twitter.feed.integration.model.AuthRes;
import com.twitter.feed.integration.networkcall.APICallback;
import com.twitter.feed.integration.util.AppUtil;
import com.twitter.feed.integration.view.AuthTokenView;
import com.twitter.feed.integration.view.BaseView;

public class AuthTokenPresenter extends BasePresenter {

    public AuthTokenPresenter(BaseView view) {
        super(view);
    }

    public void getAuthTokenCall(Context context) {

        if (!AppUtil.isNetworkAvailable(context)) {
            showNetworkAlert();
            return;
        }

        TwitterConnectionManager.getTwitterAuthToken(new APICallback<AuthRes>() {

            @Override
            public void onResponseSuccess(AuthRes response) {

                AuthTokenView view = (AuthTokenView) getView();
                if (view == null) {
                    return;
                }
                view.onAuthTokenSuccess(response);
            }

            @Override
            public void onResponseFailure(String errorMessage) {
                handleError(errorMessage);
            }
        });
    }
}
