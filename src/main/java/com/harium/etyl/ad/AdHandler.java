package com.harium.etyl.ad;

import android.app.Activity;

import com.harium.etyl.EtylMobile;
import com.harium.etyl.commons.context.Context;
import com.harium.etyl.commons.event.GUIEvent;
import com.harium.etyl.commons.event.KeyEvent;
import com.harium.etyl.commons.event.PointerEvent;
import com.harium.etyl.commons.module.Module;
import com.harium.etyl.core.graphics.Graphics;

public class AdHandler implements Module {

    protected Context context;
    protected static boolean showingAd = false;
    protected static String adKey = "";
    protected static String testDevice = "";

    private static AdProvider provider;
    private static AdHandler instance;

    private AdHandler() {
        provider = new DummyAdProvider();
    }

    public static AdHandler getInstance() {
        if (instance == null) {
            instance = new AdHandler();
        }

        return instance;
    }

    public static void setProvider(AdProvider provider) {
        AdHandler.provider = provider;
    }

    /*public abstract void init(Engine activity, View gameView);

    public abstract void showAd(Activity activity);

    public abstract void hideAd(Activity activity);*/

    public boolean isShowingAd() {
        return showingAd;
    }

    public String getAdKey() {
        return adKey;
    }

    public static void setAdKey(String adKey) {
        AdHandler.adKey = adKey;
    }

    public String getTestDevice() {
        return testDevice;
    }

    public static void setTestDevice(String testDevice) {
        AdHandler.testDevice = testDevice;
    }

    @Override
    public void updateMouse(PointerEvent event) {

    }

    @Override
    public void updateKeyboard(KeyEvent event) {

    }

    @Override
    public void updateGuiEvent(GUIEvent event) {

    }

    @Override
    public void init(Context context) {
        this.context = context;
        Activity activity = (Activity) context.getSession().get(EtylMobile.ANDROID_ACTIVITY);
        provider.init(activity);
    }

    @Override
    public void dispose(Context context) {

    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void update(long now) {
        //Update Ads
        if (!isShowingAd() && context.isShowingAd()) {
            showAdView();
        } else if (isShowingAd() && !context.isShowingAd()) {
            hideAdView();
        }
    }

    private void showAdView() {
        Activity activity = (Activity) context.getSession().get(EtylMobile.ANDROID_ACTIVITY);
        provider.showAd(activity);
        showingAd = true;
    }

    private void hideAdView() {
        Activity activity = (Activity) context.getSession().get(EtylMobile.ANDROID_ACTIVITY);
        provider.hideAd(activity);
        showingAd = false;
    }

}
