package com.twitter.feed.integration.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.twitter.feed.integration.model.TwitterTweetRes;

@Database(entities = {TwitterTweetRes.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "app_database";
    private static AppDatabase mAppDatabase;

    public static synchronized AppDatabase getSharedInstance(Context context) {
        if (mAppDatabase == null) {
            mAppDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, DATABASE_NAME).fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return mAppDatabase;
    }

    public static void destroyInstance() {
        mAppDatabase = null;
    }

    public abstract TwitterTweetDao getTwitterTweetDao();
}
