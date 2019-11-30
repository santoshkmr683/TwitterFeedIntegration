package com.twitter.feed.integration.view;

public interface BaseView {

    void showProgressBar();

    void hideProgressBar();

    void showNoNetworkAlert();

    void showError(String errorMessage);
}
