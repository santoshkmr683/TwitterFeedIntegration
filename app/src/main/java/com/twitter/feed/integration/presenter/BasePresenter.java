package com.twitter.feed.integration.presenter;

import com.twitter.feed.integration.view.BaseView;

public class BasePresenter {

    private BaseView mView;

    protected BasePresenter(BaseView view) {
        mView = view;
    }

    public void showNetworkAlert() {
        if (null != mView) {
            mView.showNoNetworkAlert();
        }
    }

    // Base implementation to handle error. If you need more control, override it.
    public void handleError(String errorMsg) {
        if (mView != null) {
            mView.showError(errorMsg);
        }
    }

    public BaseView getView() {
        return mView;
    }
}
