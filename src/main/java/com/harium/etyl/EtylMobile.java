package com.harium.etyl;

import android.os.Bundle;
import com.harium.etyl.ad.AdHandler;
import com.harium.etyl.ad.DummyAdProvider;
import com.harium.etyl.android.AndroidEngine;
import com.harium.etyl.commons.context.Application;
import com.harium.etyl.core.Engine;
import com.harium.etyl.core.GDXCore;
import com.harium.etyl.loader.FontLoader;
import com.harium.etyl.loader.MultimediaLoader;
import com.harium.etyl.loader.image.ImageLoader;

public abstract class EtylMobile extends AndroidEngine<GDXCore> implements Engine<Application> {

    private Application application;

    public EtylMobile(int w, int h) {
        super(w, h);
        addLoader(ImageLoader.getInstance());
        addLoader(FontLoader.getInstance());
        addLoader(MultimediaLoader.getInstance());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Init Ad Provider
        AdHandler.getInstance().setProvider(new DummyAdProvider());

        init();
    }

    /**
     * Based on Etyl.init() in etyl-gdx
     */
    public void init() {
        initialSetup();

        application = startApplication();
        application.setLoaded(false);
        core.setApplication(application);

        // Init Loaders
        super.init();
    }

    public GDXCore initCore() {
        return new GDXCore(w, h);
    }

}
