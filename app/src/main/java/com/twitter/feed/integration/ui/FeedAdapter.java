package com.twitter.feed.integration.ui;

import android.graphics.Typeface;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.twitter.feed.integration.R;
import com.twitter.feed.integration.event.Bus;
import com.twitter.feed.integration.model.TwitterTweetRes;
import com.twitter.feed.integration.util.AppUtil;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    private List<TwitterTweetRes> mTwitterTweetList;

    FeedAdapter(List<TwitterTweetRes> twitterTweetList){
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
        setLinkOnHttpsString(holder.descTv, mTwitterTweetList.get(position).getText());
    }

    private void setLinkOnHttpsString(final TextView textView, String desc) {

        Spannable spannableString = new SpannableString(desc);
        String httpString = AppUtil.getWordWhichStartFromHttps(desc);

        ClickableSpan linkClick = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                if (httpString != null && !httpString.isEmpty()) {
                    Bus.postClickOnUrlEvent(httpString);
                    //Toast.makeText(textView.getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setTypeface(Typeface.DEFAULT_BOLD);
                textPaint.setColor(textView.getResources().getColor(R.color.colorPrimary));
            }
        };


        if (httpString != null && !httpString.isEmpty()) {
            int length = httpString.length();
            spannableString.setSpan(linkClick, spannableString.length() - length,
                    spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            textView.setText(spannableString, TextView.BufferType.SPANNABLE);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            textView.setText(desc);
        }
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
