package com.twitter.feed.integration.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.twitter.feed.integration.model.TwitterTweetRes;

import java.util.List;

@Dao
public interface TwitterTweetDao {

    @Query("SELECT * FROM TwitterTweetRes")
    List<TwitterTweetRes> getAllTweetList();

    @Insert
    void insertAll(List<TwitterTweetRes> twitterTweetList);

    @Query("DELETE FROM TwitterTweetRes")
    void nukeTable();

}
