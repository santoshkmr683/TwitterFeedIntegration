package com.twitter.feed.integration.util;

import android.app.Activity;
import android.webkit.SslErrorHandler;

import androidx.appcompat.app.AlertDialog;

import com.twitter.feed.integration.R;

public class DialogUtil {

    public static void showWebViewSslErrorDialog(Activity activity, SslErrorHandler handler) {
        if (activity == null) {
            return;
        }
        AlertDialog dialog = new AlertDialog.Builder(activity)
                .setMessage(R.string.ssl_certificate_invalid)
                .setPositiveButton("Continue", (dialog1, which) -> handler.proceed())
                .setNegativeButton("Cancel", (dialog1, which) -> handler.cancel()).create();
        dialog.setCancelable(false);
        if (!activity.isFinishing()) {
            dialog.show();
        }
    }
}
