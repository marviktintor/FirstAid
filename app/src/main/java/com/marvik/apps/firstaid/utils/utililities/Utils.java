package com.marvik.apps.firstaid.utils.utililities;

import android.content.Context;

import com.marvik.apps.firstaid.database.transactions.TransactionsManager;

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
}
