package com.harium.etyl;

import android.content.pm.PackageManager;
import android.os.Build;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.harium.etyl.android.AndroidCore;

public abstract class AndroidEngine extends AndroidApplication {

    protected int w;
    protected int h;

    protected AndroidCore core;

    public AndroidEngine(int w, int h) {
        super();

        this.w = w;
        this.h = h;

        core = initCore();
        core.setActivity(this);
    }

    protected abstract AndroidCore initCore();

    // Util permission methods
    protected boolean hasPermission(String... permissions) {
        if (needPermission()) {
            for (String permission : permissions) {
                return checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
            }
        }

        return true;
    }

    protected boolean needPermission() {
        return Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1;
    }

}
