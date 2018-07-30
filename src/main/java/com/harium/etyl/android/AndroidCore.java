package com.harium.etyl.android;

import android.app.Activity;

import com.harium.etyl.EtylMobile;
import com.harium.etyl.commons.context.Context;
import com.harium.etyl.core.GDXCore;

public class AndroidCore<T extends Context> extends GDXCore<T> {

    //Android Specific
    private Activity activity;

    public AndroidCore(int w, int h) {
        super(w, h);
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
        session.put(EtylMobile.ANDROID_ACTIVITY, activity);
    }

    public Activity getActivity() {
        return activity;
    }
}
