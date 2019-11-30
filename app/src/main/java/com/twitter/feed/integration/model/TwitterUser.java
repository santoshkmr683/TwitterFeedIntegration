package com.twitter.feed.integration.model;

import com.google.gson.annotations.SerializedName;

public class TwitterUser {

	@SerializedName("id")
	private int id;

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

	@SerializedName("created_at")
	private String createdAt;

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

	@SerializedName("profile_link_color")
	private String profileLinkColor;

	@SerializedName("profile_sidebar_border_color")
	private String profileSidebarBorderColor;

	@SerializedName("profile_sidebar_fill_color")
	private String profileSidebarFillColor;

	@SerializedName("profile_text_color")
	private String profileTextColor;

	@SerializedName("profile_use_background_image")
	private boolean profileUseBackgroundImage;

	@SerializedName("has_extended_profile")
	private boolean hasExtendedProfile;

	@SerializedName("default_profile")
	private boolean defaultProfile;

	@SerializedName("default_profile_image")
	private boolean defaultProfileImage;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
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

	public String getProfileLinkColor() {
		return profileLinkColor;
	}

	public void setProfileLinkColor(String profileLinkColor) {
		this.profileLinkColor = profileLinkColor;
	}

	public String getProfileSidebarBorderColor() {
		return profileSidebarBorderColor;
	}

	public void setProfileSidebarBorderColor(String profileSidebarBorderColor) {
		this.profileSidebarBorderColor = profileSidebarBorderColor;
	}

	public String getProfileSidebarFillColor() {
		return profileSidebarFillColor;
	}

	public void setProfileSidebarFillColor(String profileSidebarFillColor) {
		this.profileSidebarFillColor = profileSidebarFillColor;
	}

	public String getProfileTextColor() {
		return profileTextColor;
	}

	public void setProfileTextColor(String profileTextColor) {
		this.profileTextColor = profileTextColor;
	}

	public boolean isProfileUseBackgroundImage() {
		return profileUseBackgroundImage;
	}

	public void setProfileUseBackgroundImage(boolean profileUseBackgroundImage) {
		this.profileUseBackgroundImage = profileUseBackgroundImage;
	}

	public boolean isHasExtendedProfile() {
		return hasExtendedProfile;
	}

	public void setHasExtendedProfile(boolean hasExtendedProfile) {
		this.hasExtendedProfile = hasExtendedProfile;
	}

	public boolean isDefaultProfile() {
		return defaultProfile;
	}

	public void setDefaultProfile(boolean defaultProfile) {
		this.defaultProfile = defaultProfile;
	}

	public boolean isDefaultProfileImage() {
		return defaultProfileImage;
	}

	public void setDefaultProfileImage(boolean defaultProfileImage) {
		this.defaultProfileImage = defaultProfileImage;
	}
}
