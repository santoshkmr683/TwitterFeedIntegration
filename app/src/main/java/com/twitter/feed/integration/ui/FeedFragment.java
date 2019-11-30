package com.twitter.feed.integration.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.twitter.feed.integration.R;
import com.twitter.feed.integration.model.AuthRes;
import com.twitter.feed.integration.model.TwitterTweet;
import com.twitter.feed.integration.presenter.AuthTokenPresenter;
import com.twitter.feed.integration.presenter.TweetListPresenter;
import com.twitter.feed.integration.view.AuthTokenView;
import com.twitter.feed.integration.view.TweetListView;

import java.util.List;

/**
 * A simple {@link BaseFragment} subclass.
 */
public class FeedFragment extends BaseFragment implements AuthTokenView, TweetListView {

    private RecyclerView mRecyclerView;

    public FeedFragment() {
        // Required empty public constructor
    }

    public static FeedFragment newInstance() {

        Bundle args = new Bundle();

        FeedFragment fragment = new FeedFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setLayout(R.layout.fragment_feed);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_view);
        showProgressBar();
        new AuthTokenPresenter(this).getAuthTokenCall(getContext());
    }

    @Override
    public void onAuthTokenSuccess(AuthRes authRes) {
        new TweetListPresenter(this).getAuthTokenCall(getContext(), authRes.getAccessToken());
    }

    @Override
    public void onTweetsSuccess(List<TwitterTweet> twitterTweetList) {
        hideProgressBar();
        setRecyclerViewData(twitterTweetList);
    }

    /**
     * This method is used to set recycler view data
     * @param twitterTweetList is an instance of twitter list
     */
    private void setRecyclerViewData(List<TwitterTweet> twitterTweetList) {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(new FeedAdapter(twitterTweetList));
    }
}
