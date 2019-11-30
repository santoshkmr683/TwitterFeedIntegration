package com.twitter.feed.integration.ui;


import android.content.Intent;
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
import com.twitter.feed.integration.database.AppDatabase;
import com.twitter.feed.integration.event.Bus;
import com.twitter.feed.integration.event.ProfileClickEvent;
import com.twitter.feed.integration.event.UrlEvent;
import com.twitter.feed.integration.model.AuthRes;
import com.twitter.feed.integration.model.TwitterTweetRes;
import com.twitter.feed.integration.presenter.AuthTokenPresenter;
import com.twitter.feed.integration.presenter.TweetListPresenter;
import com.twitter.feed.integration.util.AppUtil;
import com.twitter.feed.integration.util.Constant;
import com.twitter.feed.integration.util.FragmentHelper;
import com.twitter.feed.integration.view.AuthTokenView;
import com.twitter.feed.integration.view.TweetListView;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * A simple {@link BaseFragment} subclass.
 */
public class FeedFragment extends BaseFragment implements
        AuthTokenView, TweetListView {

    private RecyclerView mRecyclerView;

    public FeedFragment() {
        // Required empty public constructor
    }

    static FeedFragment newInstance() {

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
        Bus.register(this);
        initView(view);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Bus.unregister(this);
    }

    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_view);
        new AuthTokenPresenter(this).getAuthTokenCall(getContext());
    }

    @Override
    public void onAuthTokenSuccess(AuthRes authRes) {
        new TweetListPresenter(this).getAuthTokenCall(getContext(),
                authRes.getAccessToken(), Constant.SCREEN_NAME);
    }

    @Override
    public void onTweetsSuccess(List<TwitterTweetRes> twitterTweetList) {
        hideProgressBar();
        AppDatabase.getSharedInstance(getContext()).getTwitterTweetDao().nukeTable();
        AppDatabase.getSharedInstance(getContext()).getTwitterTweetDao().insertAll(twitterTweetList);
        setRecyclerViewData(twitterTweetList);
    }

    /**
     * This method is used to set recycler view data
     * @param twitterTweetList is an instance of twitter list
     */
    private void setRecyclerViewData(List<TwitterTweetRes> twitterTweetList) {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(new FeedAdapter(twitterTweetList));
    }

    @Subscribe
    public void onFeedUrlClick(UrlEvent urlEvent) {
        if (urlEvent != null && urlEvent.getUrl() != null &&
                !urlEvent.getUrl().isEmpty() && getContext() != null &&
                AppUtil.isNetworkAvailable(getContext())) {
            Intent intent = new Intent(getActivity(), WebViewActivity.class);
            intent.putExtra(Constant.KEY_URL, urlEvent.getUrl());
            startActivity(intent);
        }
    }

    @Subscribe
    public void onProfileImgClick(ProfileClickEvent profileClickEvent) {
        FragmentHelper.addFragment(getActivity(), ProfileFragment
                .newInstance(profileClickEvent), R.id.fragment_container);
    }



    @Override
    public void showNoNetworkAlert() {
        super.showNoNetworkAlert();
        List<TwitterTweetRes> tweetList = AppDatabase.getSharedInstance(getContext())
                .getTwitterTweetDao().getAllTweetList();
        if (tweetList != null && tweetList.size() > 0){
            setRecyclerViewData(tweetList);
        }
    }
}
