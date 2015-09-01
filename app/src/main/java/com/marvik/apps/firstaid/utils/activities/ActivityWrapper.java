package com.marvik.apps.firstaid.utils.activities;

import android.app.Activity;
import android.os.Bundle;

import com.marvik.apps.firstaid.utils.utililities.Utils;

/**
 * Created by victor on 9/1/2015.
 */
public abstract class ActivityWrapper extends Activity {
    private Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        utils = new Utils(ActivityWrapper.this);
        onCreateActivity(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        onResumeActivity();
    }

    @Override
    protected void onPause() {
        super.onPause();
        onPauseActivity();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDestroyActivity();
    }

    protected abstract void onCreateActivity(Bundle savedInstanceState);

    protected abstract void onResumeActivity();

    protected abstract void onPauseActivity();

    protected abstract void onDestroyActivity();

    public Utils getUtils() {
        return utils;
    }
}

