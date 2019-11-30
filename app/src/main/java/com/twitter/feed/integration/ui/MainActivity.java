package com.twitter.feed.integration.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.twitter.feed.integration.R;
import com.twitter.feed.integration.util.FragmentHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentHelper.replaceFragment(this, FeedFragment
                .newInstance(), R.id.fragment_container);
    }
}
