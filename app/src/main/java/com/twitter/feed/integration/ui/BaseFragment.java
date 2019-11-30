package com.twitter.feed.integration.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.twitter.feed.integration.R;
import com.twitter.feed.integration.util.Constant;
import com.twitter.feed.integration.view.BaseView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment implements BaseView {

    private int mLayoutId;
    private View mViewProgressBarContainer;

    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        FrameLayout fragmentLayoutContainer = view.findViewById(R.id.layout_container);
        inflater.inflate(mLayoutId, fragmentLayoutContainer);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewProgressBarContainer = view.findViewById(R.id.progress_bar_container);
    }

    void setLayout(int layoutId) {
        mLayoutId = layoutId;
    }

    @Override
    public void showProgressBar() {
        if (mViewProgressBarContainer != null) {
            mViewProgressBarContainer.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void hideProgressBar() {
        if (mViewProgressBarContainer != null) {
            mViewProgressBarContainer.setVisibility(View.GONE);
        }
    }

    @Override
    public void showNoNetworkAlert() {
        Toast.makeText(getContext(), Constant.INTERNET_CONNECTION_MSG, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(getContext(), errorMessage + " "+ Constant.SERVER_ERROR, Toast.LENGTH_SHORT).show();
    }
}
