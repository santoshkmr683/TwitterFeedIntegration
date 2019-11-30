package com.twitter.feed.integration.model;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;

@Entity
public class TwitterUser {

	@SerializedName("id_str")
	private String idStr;

	@SerializedName("name")
	private String name;

	@SerializedName("screen_name")
	private String screenName;

	@SerializedName("location")
	private String location;

	@SerializedName("description")
	private String description;

	@SerializedName("url")
	private String url;

	@SerializedName("followers_count")
	private int followersCount;

	@SerializedName("friends_count")
	private int friendsCount;

	@SerializedName("listed_count")
	private int listedCount;

	@SerializedName("favourites_count")
	private int favouritesCount;

	@SerializedName("statuses_count")
	private int statusesCount;

	@SerializedName("profile_image_url")
	private String profileImageUrl;

	@SerializedName("profile_image_url_https")
	private String profileImageUrlHttps;

	@SerializedName("profile_banner_url")
	private String profileBannerUrl;

	public String getIdStr() {
		return idStr;
	}

	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	public int getFriendsCount() {
		return friendsCount;
	}

	public void setFriendsCount(int friendsCount) {
		this.friendsCount = friendsCount;
	}

	public int getListedCount() {
		return listedCount;
	}

	public void setListedCount(int listedCount) {
		this.listedCount = listedCount;
	}

	public int getFavouritesCount() {
		return favouritesCount;
	}

	public void setFavouritesCount(int favouritesCount) {
		this.favouritesCount = favouritesCount;
	}


	public int getStatusesCount() {
		return statusesCount;
	}

	public void setStatusesCount(int statusesCount) {
		this.statusesCount = statusesCount;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public String getProfileImageUrlHttps() {
		return profileImageUrlHttps;
	}

	public void setProfileImageUrlHttps(String profileImageUrlHttps) {
		this.profileImageUrlHttps = profileImageUrlHttps;
	}

	public String getProfileBannerUrl() {
		return profileBannerUrl;
	}

	public void setProfileBannerUrl(String profileBannerUrl) {
		this.profileBannerUrl = profileBannerUrl;
	}

}
