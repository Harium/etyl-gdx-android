package com.harium.etyl.android;

import android.content.pm.PackageManager;
import android.os.Build;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.harium.etyl.EtylMobile;
import com.harium.etyl.core.GDXCore;
import com.harium.etyl.loader.Loader;
import com.harium.etyl.util.PathHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Based on etyl-gdx-lwjgl BaseEngine
 *
 * @param <T>
 */
public abstract class AndroidEngine<T extends GDXCore> extends AndroidApplication {

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
        core.getSession().put(EtylMobile.ANDROID_ACTIVITY, this);
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
