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
        String [] attacks = {"","Asthma Attack","Burns","Burns","Burns","Bone Fracture","Chemical Burns","Cuts and Wounds","Drowning",
                "Electric Burns","Heart Attack/Arrest","Hypothermia","Hiccups","Snake Bites","Stings","Attention","Stroke","Pulse","CPR"};

        ContentValues values = null;
        int degree = 0;
        for(int i = 1;i < attacks.length; i++){

            values = new ContentValues();
            values.put(Tables.Attacks.COL_ATTACK,attacks[i]);
            if(i > 1 && i < 5) {
                degree++;
                values.put(Tables.Attacks.COL_DEGREE, degree);
            }
            getTransactionsManager().getSqLiteDatabase().insert(Tables.Attacks.TABLE_NAME,null,values);
        }
       Asthma-> Coughing,Wheezing (whistling sound when breathing),Shortness of breath,Chest tightness,Inability to talk (this varies with the magnitude of the attack)
        Sit/make the victim sit upright,Ensure a comfortable position by raising the hands forward,Breathe in deeply by exhaling sharply,Do this in multiple rounds until normal breathing,After 30 minutes use your/their medicated inhaler
        NOTE: If the victim cannot talk, call emergency medical unit first.









        String [] symptoms = {};
        String [] firstAids = {};
        String [] notes = {};

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor=  prefs.edit();
        editor.putBoolean(Prefs.FIRSTRUN,false);
        editor.commit();
    }
}
