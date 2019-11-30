package com.twitter.feed.integration.presenter;

import com.twitter.feed.integration.view.BaseView;

public class BasePresenter {

    private BaseView mView;

    BasePresenter(BaseView view) {
        mView = view;
    }

    void showNetworkAlert() {
        if (null != mView) {
            mView.showNoNetworkAlert();
        }
    }

    void showProgressBar() {
        if (null != mView) {
            mView.showProgressBar();
        }
    }

    // Base implementation to handle error. If you need more control, override it.
    void handleError(String errorMsg) {
        if (mView != null) {
            mView.showError(errorMsg);
        }
    }

    public BaseView getView() {
        return mView;
    }
}
