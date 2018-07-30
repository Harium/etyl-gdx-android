package com.harium.etyl;

import android.os.Bundle;

import com.harium.etyl.ad.AdHandler;
import com.harium.etyl.ad.DummyAdProvider;
import com.harium.etyl.android.AndroidCore;
import com.harium.etyl.commons.context.Application;
import com.harium.etyl.core.Engine;
import com.harium.etyl.util.PathHelper;

public abstract class EtylMobile extends AndroidEngine implements Engine<Application> {

    public static final String ANDROID_ACTIVITY = "ANDROID_ACTIVITY";

    private Application application;

    public EtylMobile(int w, int h) {
        super(w, h);
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PathHelper.assetManager = getAssets();

        initialize(core);

        application = startApplication();
        core.setApplication(application);
    }

    public AndroidCore initCore() {
        //Init Ad Provider
        AdHandler.getInstance().setProvider(new DummyAdProvider());
        return new AndroidCore(w, h);
    }

}
