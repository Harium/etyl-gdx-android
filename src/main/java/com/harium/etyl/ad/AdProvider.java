package com.harium.etyl.ad;

import android.app.Activity;

public interface AdProvider {
    void init(Activity activity);
    void showAd(Activity activity);
    void hideAd(Activity activity);
}
