package com.harium.etyl.android;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.harium.etyl.core.GDXCore;
import com.harium.etyl.loader.Loader;
import com.harium.etyl.util.PathHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Based on etyl-gdx-lwjgl BaseEngine
 *
 * @param <T> Core class that extends GDXCore
 */
public abstract class AndroidEngine<T extends GDXCore> extends AndroidApplication {

    public static final String ANDROID_ACTIVITY = "ANDROID_ACTIVITY";

    protected int w;
    protected int h;

    protected GDXCore core;
    protected List<Loader> loaders;

    public AndroidEngine(int w, int h) {
        super();

        this.w = w;
        this.h = h;

        loaders = new ArrayList<>();

        core = initCore();
        core.getSession().put(ANDROID_ACTIVITY, this);
    }

    public void init() {
        initLoaders();
    }

    protected void initialSetup() {
        // Initial Setup
        PathHelper.assetManager = getAssets();

        // Initialize LibGDX
        initialize(core);
    }

    protected void initLoaders() {
        for (Loader loader : loaders) {
            loader.setAssets(core.getAssets());
        }
    }

    protected void addLoader(Loader loader) {
        loaders.add(loader);
    }

    protected abstract T initCore();

    @Override
    public void initialize(ApplicationListener listener) {
        AndroidApplicationConfiguration config = buildConfiguration();
        this.initialize(listener, config);
    }

    protected AndroidApplicationConfiguration buildConfiguration() {
        return new AndroidApplicationConfiguration();
    }

}
