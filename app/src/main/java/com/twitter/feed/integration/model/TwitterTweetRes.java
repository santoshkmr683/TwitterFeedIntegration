package com.twitter.feed.integration.model;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class TwitterTweetRes {


	@PrimaryKey
	@SerializedName("id")
	@NonNull
	private String id = "1000000000000000001";

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("text")
	private String text;

	@SerializedName("in_reply_to_status_id")
	private String inReplyToStatusId;

	@SerializedName("in_reply_to_user_id")
	private String inReplyToUserId;

	@SerializedName("in_reply_to_screen_name")
	private String inReplyToScreenName;

	@Embedded
	@SerializedName("user")
	private TwitterUser twitterUser;

	public String getCreatedAt() {
		return createdAt;
	}

	@NonNull
	public String getId() {
		return id;
	}

	public String getInReplyToScreenName() {
		return inReplyToScreenName;
	}

	public String getInReplyToStatusId() {
		return inReplyToStatusId;
	}

	public String getInReplyToUserId() {
		return inReplyToUserId;
	}

	public String getText() {
		return text;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setId(@NonNull String id) {
		this.id = id;
	}

	public void setInReplyToScreenName(String inReplyToScreenName) {
		this.inReplyToScreenName = inReplyToScreenName;
	}
	
	public void setInReplyToStatusId(String inReplyToStatusId) {
		this.inReplyToStatusId = inReplyToStatusId;
	}
	
	public void setInReplyToUserId(String inReplyToUserId) {
		this.inReplyToUserId = inReplyToUserId;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public void setTwitterUser(TwitterUser twitterUser) {
		this.twitterUser = twitterUser;
	}

	public TwitterUser getTwitterUser() {
		return twitterUser;
	}

}
