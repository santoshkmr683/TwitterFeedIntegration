package com.twitter.feed.integration.ui;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.twitter.feed.integration.R;
import com.twitter.feed.integration.model.TwitterTweet;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    private List<TwitterTweet> mTwitterTweetList;

    FeedAdapter(List<TwitterTweet> twitterTweetList){
        this.mTwitterTweetList = twitterTweetList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_item_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.profileImgView.setImageURI(Uri.parse(mTwitterTweetList.get(position)
                .getTwitterUser().getProfileImageUrl()));
        holder.nameTv.setText(mTwitterTweetList.get(position).getTwitterUser().getName());
        holder.descTv.setText(mTwitterTweetList.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return mTwitterTweetList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private SimpleDraweeView profileImgView;
        private TextView nameTv;
        private TextView descTv;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImgView = itemView.findViewById(R.id.profile_img);
            nameTv = itemView.findViewById(R.id.user_name);
            descTv = itemView.findViewById(R.id.desc);
        }
    }
}
