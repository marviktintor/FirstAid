package com.marvik.apps.firstaid.utils.utililities;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.marvik.apps.firstaid.database.tables.Tables;
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
        String [] attacks = null;
        ContentValues values = null;
        int degree = 0;
        for(int i = 0;i < attacks.length; i++){

            values = new ContentValues();
            values.put(Tables.Attacks.COL_ATTACK,attacks[i]);
            if(i > 0 && i < 4) {
                degree++;
                values.put(Tables.Attacks.COL_DEGREE, degree);
            }
            getTransactionsManager().getSqLiteDatabase().insert(Tables.Attacks.TABLE_NAME,null,values);
            insertSymptom(i + 1);
            insertFirstAid(i + 1);
            insertNote(i + 1);
        }



        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor=  prefs.edit();
        editor.putBoolean(Prefs.FIRSTRUN,false);
        editor.commit();
    }

    private void insertSymptom (int attackId){}
    private void insertFirstAid (int attackId){}
    private void insertNote (int attackId){}
}
