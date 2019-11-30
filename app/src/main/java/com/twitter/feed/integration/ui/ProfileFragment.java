package com.twitter.feed.integration.ui;


import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.drawee.view.SimpleDraweeView;
import com.twitter.feed.integration.R;
import com.twitter.feed.integration.event.ProfileClickEvent;
import com.twitter.feed.integration.model.TwitterUser;
import com.twitter.feed.integration.util.Constant;

/**
 * A simple {@link BaseFragment} subclass.
 */
public class ProfileFragment extends BaseFragment {

    private SimpleDraweeView mProfileBannerImg;
    private SimpleDraweeView mProfileImg;
    private TextView mUserName;
    private TextView mDesc;
    private TextView mLocation;
    private TextView mFollowingCount;
    private TextView mFollowersCount;

    public ProfileFragment() {
        // Required empty public constructor
    }

    static ProfileFragment newInstance(ProfileClickEvent profileClickEvent) {
        
        Bundle args = new Bundle();
        args.putSerializable(Constant.SERIALIZABLE_KEY, profileClickEvent);
        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setLayout(R.layout.fragment_profile);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        setDataFromBundle();
    }

    private void setDataFromBundle(){
        if (getArguments() != null) {
            ProfileClickEvent profileClickEvent = (ProfileClickEvent) getArguments()
                    .getSerializable(Constant.SERIALIZABLE_KEY);
            if (profileClickEvent != null) {
                TwitterUser twitterUser = profileClickEvent.getTwitterUser();
                if (twitterUser != null){
                    mProfileImg.setImageURI(Uri.parse(twitterUser.getProfileImageUrl()));
                    mProfileBannerImg.setImageURI(Uri.parse(twitterUser.getProfileBannerUrl()));
                    mUserName.setText(twitterUser.getName());
                    mDesc.setText(twitterUser.getDescription());
                    mLocation.setText(twitterUser.getLocation());
                    mFollowingCount.setText(String.valueOf(twitterUser.getFriendsCount()));
                    mFollowersCount.setText(String.valueOf(twitterUser.getFollowersCount()));
                }
            }
        }
    }

    private void initView(View view) {
        ImageView backBtn = view.findViewById(R.id.back_btn);
        mProfileBannerImg = view.findViewById(R.id.profile_banner_img);
        mProfileImg = view.findViewById(R.id.profile_img);
        mUserName = view.findViewById(R.id.user_name);
        mDesc = view.findViewById(R.id.desc);
        mLocation = view.findViewById(R.id.location);
        mFollowingCount = view.findViewById(R.id.following_count);
        mFollowersCount = view.findViewById(R.id.follower_count);

        backBtn.setOnClickListener(v -> {
            if (getActivity() != null){
                getActivity().onBackPressed();
            }
        });
    }
}
