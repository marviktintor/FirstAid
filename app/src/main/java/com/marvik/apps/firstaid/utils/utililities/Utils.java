package com.marvik.apps.firstaid.utils.utililities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.marvik.apps.firstaid.database.transactions.TransactionsManager;
import com.marvik.apps.firstaid.utils.prefs.Prefs;

/**
 * Created by victor on 9/1/2015.
 */
public class Utils {
    private TransactionsManager transactionsManager;
    private Context context;

    public Utils(Context context) {
        this.context = context;
        transactionsManager = new TransactionsManager(getContext());
    }

    public Context getContext() {
        return context;
    }

    public TransactionsManager getTransactionsManager() {
        return transactionsManager;
    }

    public boolean isFirstRun() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        return prefs.getBoolean(Prefs.FIRSTRUN,true);
    }

    public void initAttacksFirstAids() {







        String [] symptoms = {};
        String [] firstAids = {};
        String [] notes = {};
    }
}
