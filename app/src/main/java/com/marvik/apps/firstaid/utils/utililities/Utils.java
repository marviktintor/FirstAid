package com.marvik.apps.firstaid.utils.utililities;

import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;

import androidx.core.app.NotificationCompat;

import com.marvik.apps.firstaid.R;
import com.marvik.apps.firstaid.database.tables.Tables;
import com.marvik.apps.firstaid.database.transactions.TransactionsManager;
import com.marvik.apps.firstaid.utils.data.Data;
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
        return prefs.getBoolean(Prefs.FIRSTRUN, true);
    }

    public void initAttacksFirstAids() {
        String[] attacks = Data.attacks;
        ContentValues values = null;
        int degree = 0;
        for (int i = 0; i < attacks.length; i++) {

            values = new ContentValues();
            values.put(Tables.Attacks.COL_ATTACK, attacks[i]);
            values.put(Tables.Attacks.COL_DEGREE, -1);
            if (i > 0 && i < 4) {
                degree++;
                values.put(Tables.Attacks.COL_DEGREE, degree);
            }
            getTransactionsManager().getSqLiteDatabase().insert(Tables.Attacks.TABLE_NAME, null, values);
            insertSymptom(i + 1);
            insertFirstAid(i + 1);
            insertNote(i + 1);
        }


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(Prefs.FIRSTRUN, false);
        editor.commit();
    }

    private void insertSymptom(int attackId) {
        String[] symptoms = Data.symptoms;
        ContentValues values = new ContentValues();
        values.put(Tables.Symptoms.COL_ATTACK_ID, attackId);
        values.put(Tables.Symptoms.COL_SYMPTOM, symptoms[attackId - 1]);
        getTransactionsManager().getSqLiteDatabase().insert(Tables.Symptoms.TABLE_NAME, null, values);
    }

    private void insertFirstAid(int attackId) {
        String[] firstAid = Data.firstAid;
        ContentValues values = new ContentValues();
        values.put(Tables.FirstAids.COL_ATTACK_ID, attackId);
        values.put(Tables.FirstAids.COL_FIRST_AID, firstAid[attackId - 1]);
        getTransactionsManager().getSqLiteDatabase().insert(Tables.FirstAids.TABLE_NAME, null, values);
    }

    private void insertNote(int attackId) {
        String[] notes = Data.notes;
        ContentValues values = new ContentValues();
        values.put(Tables.Notes.COL_ATTACK_ID, attackId);
        values.put(Tables.Notes.COL_NOTE, notes[attackId - 1]);
        getTransactionsManager().getSqLiteDatabase().insert(Tables.Notes.TABLE_NAME, null, values);
    }

    public int enableTimeBomb() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        int launches = prefs.getInt("launches",1);
        if(launches > 5){
            NotificationCompat.Builder  notificationBuilder = new NotificationCompat.Builder(getContext());
            notificationBuilder.setContentIntent(null);
            notificationBuilder.setSubText("Launches : " + launches + "\n Allowed 5 Launches.");
            notificationBuilder.setContentText("First Aid Huduma Usage Analytics");
            notificationBuilder.setContentTitle("First Aid Huduma");
            notificationBuilder.setSmallIcon( R.mipmap.ic_launcher);
            notificationBuilder.setLargeIcon(BitmapFactory.decodeResource(getContext().getResources(), R.mipmap.ic_launcher));
            NotificationManager manager = (NotificationManager)getContext().getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(232343, notificationBuilder.build());
        }

        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("launches",launches + 1);
        editor.commit();
        return launches;
    }
}
