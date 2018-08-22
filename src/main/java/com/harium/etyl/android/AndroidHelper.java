package com.harium.etyl.android;

import android.app.Activity;

import android.content.pm.PackageManager;
import android.os.Build;
import com.harium.etyl.android.AndroidEngine;
import com.harium.etyl.commons.context.Context;

public class AndroidHelper {

    public static Activity activity(Context context) {
        return (Activity) context.getSession().get(AndroidEngine.ANDROID_ACTIVITY);
    }

    // Permission methods
    public static boolean hasPermission(Activity activity, String... permissions) {
        if (needPermission()) {
            for (String permission : permissions) {
                return activity.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
            }
        }

        return true;
    }

    public static boolean hasPermission(Context context, String... permissions) {
        Activity activity = activity(context);
        return hasPermission(activity, permissions);
    }

    public static boolean needPermission() {
        return Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1;
    }
}
