package com.marvik.apps.firstaid.database.transactions;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.marvik.apps.firstaid.customlist.AttacksCustomList;
import com.marvik.apps.firstaid.database.schemas.DatabaseSchema;
import com.marvik.apps.firstaid.database.tables.Tables;
import com.marvik.apps.firstaid.infos.AttacksInfo;
import com.marvik.apps.firstaid.infos.FirstAidInfo;
import com.marvik.apps.firstaid.infos.NotesInfo;
import com.marvik.apps.firstaid.infos.SymptomsInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victor on 9/1/2015.
 */
public class TransactionsManager {

    private Context context;
    private List<AttacksInfo> attacksInfoList;
    private List<SymptomsInfo> symptomsInfoList;
    private List<FirstAidInfo> firstAidInfoList;
    private List<NotesInfo> notesInfoList;

    private Cursor attacksCursor, symptomsCursor, firstAidCursor, notesCursor;
    private SQLiteDatabase sqLiteDatabase;
    private DatabaseSchema databaseSchema;

    public TransactionsManager(Context context) {
        this.context = context;
        databaseSchema = new DatabaseSchema(getContext());
    }

    public Context getContext() {
        return context;
    }

    public List<AttacksInfo> getAttacksInfoList(String attack) {
        String selection = null;
        if (attack != null || !attack.equals("")) {
            selection = Tables.Attacks.COL_ATTACK + " LIKE '%" + attack + "%'";
        }
        Cursor cursor = getAttacksCursor(null, selection, null, null, null, null);

        if (cursor != null) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                int attackId = cursor.getInt(cursor.getColumnIndex(Tables.Attacks.COL_ATTACK_ID));
                String _attack = cursor.getString(cursor.getColumnIndex(Tables.Attacks.COL_ATTACK));
                int degree = cursor.getInt(cursor.getColumnIndex(Tables.Attacks.COL_DEGREE));
                attacksInfoList.add(new AttacksInfo(attackId, _attack, degree));
            }
        }

        if (cursor != null) {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }
        return attacksInfoList;
    }

    public List<SymptomsInfo> getSymptomsInfoList(int  attackId) {
        symptomsInfoList = new ArrayList<SymptomsInfo>();
        String selection = null;
        if (attackId != -1 ) {
            selection = Tables.Symptoms.COL_ATTACK_ID + "='" + attackId + "'";
        }
        Cursor cursor = getSymptomsCursor(null, selection, null, null, null, null);
        if (cursor != null) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                int symptomId = cursor.getInt(cursor.getColumnIndex(Tables.Symptoms.COL_SYMPTOM_ID));
                String symptom = cursor.getString(cursor.getColumnIndex(Tables.Symptoms.COL_SYMPTOM));
                //int attackId = cursor.getInt(cursor.getColumnIndex(Tables.Symptoms.COL_ATTACK_ID));
                String [] symptoms = symptom.split(",");
                for(String _symptom : symptoms){
                    symptomsInfoList.add(new SymptomsInfo(symptomId, _symptom, attackId));
                }

            }
        }

        if (cursor != null) {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }
        return symptomsInfoList;
    }

    public List<FirstAidInfo> getFirstAidInfoList(int attackId) {

        firstAidInfoList = new ArrayList<FirstAidInfo>();

        String selection = null;
        if (attackId != -1) {
            selection = Tables.FirstAids.COL_ATTACK_ID + "='" + attackId + "'";
        }

        Cursor cursor = getFirstAidCursor(null, selection, null, null, null, null);

        if (cursor != null) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

                int firstAidId = cursor.getInt(cursor.getColumnIndex(Tables.FirstAids.COL_FIRST_AID_ID));
                String firstAid = cursor.getString(cursor.getColumnIndex(Tables.FirstAids.COL_FIRST_AID));
                //int attackId = cursor.getInt(cursor.getColumnIndex(Tables.FirstAids.COL_ATTACK_ID));
                String [] firstAids = firstAid.split(",");
                for(String _firstAid : firstAids){
                    firstAidInfoList.add(new FirstAidInfo(firstAidId, _firstAid, attackId));
                }



            }
        }

        if (cursor != null) {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }
        return firstAidInfoList;
    }

    public List<NotesInfo> getNotesInfoList(int attackId) {

        notesInfoList = new ArrayList<NotesInfo>();

        String selection = null;
        if (attackId != -1) {
            selection = Tables.Notes.COL_ATTACK_ID + "='" + attackId + "'";
        }

        Cursor cursor = getNotesCursor(null, selection, null, null, null, null);

        if (cursor != null) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

                int notesId = cursor.getInt(cursor.getColumnIndex(Tables.Notes.COL_NOTE_ID));
                String note = cursor.getString(cursor.getColumnIndex(Tables.Notes.COL_NOTE));
                //int attackId = cursor.getInt(cursor.getColumnIndex(Tables.Notes.COL_ATTACK_ID));
                String [] notes = note.split(",");
                for(String _notes : notes){
                    notesInfoList.add(new NotesInfo(notesId, _notes, attackId));
                }


            }
        }
        if (cursor != null) {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }

        return notesInfoList;
    }

    public Cursor getAttacksCursor(String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return getSqLiteDatabase().query(Tables.Attacks.TABLE_NAME, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    public Cursor getSymptomsCursor(String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return getSqLiteDatabase().query(Tables.Symptoms.TABLE_NAME, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    public Cursor getFirstAidCursor(String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return getSqLiteDatabase().query(Tables.FirstAids.TABLE_NAME, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    public Cursor getNotesCursor(String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return getSqLiteDatabase().query(Tables.Notes.TABLE_NAME, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    public SQLiteDatabase getSqLiteDatabase() {
        if (sqLiteDatabase == null) {
            sqLiteDatabase = databaseSchema.getReadableDatabase();
        }
        return sqLiteDatabase;
    }

    public DatabaseSchema getDatabaseSchema() {
        return databaseSchema;
    }

    public List<AttacksCustomList> getAttacksCustomList(String search) {
        String selection = null;
        if(search != null && !search.equals("")){
            selection = Tables.Attacks.COL_ATTACK+" LIKE '%" +search +"%'";
        }
        List<AttacksCustomList> attacksCustomLists = new ArrayList<AttacksCustomList>();
        Cursor attacksCursor = getAttacksCursor(null, selection, null, null, null, null);
        if (attacksCursor != null) {

            for (attacksCursor.moveToNext(); !attacksCursor.isAfterLast(); attacksCursor.moveToNext()) {
                int attackId = attacksCursor.getInt(attacksCursor.getColumnIndex(Tables.Attacks.COL_ATTACK_ID));
                String attack = attacksCursor.getString(attacksCursor.getColumnIndex(Tables.Attacks.COL_ATTACK));

                String _selection = Tables.Symptoms.COL_ATTACK_ID +"='" +attackId +"'";
                Cursor symptomsCursor = getSymptomsCursor(null, _selection, null, null, null, null);
                if (symptomsCursor != null) {

                    symptomsCursor.moveToFirst();
                    String symptom = symptomsCursor.getString(symptomsCursor.getColumnIndex(Tables.Symptoms.COL_SYMPTOM));
                    attacksCustomLists.add(new AttacksCustomList(attackId, attack, symptom));
                }
            }


        }
        return attacksCustomLists;
    }

    public List<AttacksInfo> getAttack(int attackId) {
        List<AttacksInfo>attacksInfos = new ArrayList<AttacksInfo>();
        String selection = null;
        if (attackId != -1 ) {
            selection = Tables.Attacks.COL_ATTACK_ID + "='" + attackId + "'";
        }
        Cursor cursor = getAttacksCursor(null, selection, null, null, null, null);

        if (cursor != null) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
               // int attackId = cursor.getInt(cursor.getColumnIndex(Tables.Attacks.COL_ATTACK_ID));
                String _attack = cursor.getString(cursor.getColumnIndex(Tables.Attacks.COL_ATTACK));
                int degree = cursor.getInt(cursor.getColumnIndex(Tables.Attacks.COL_DEGREE));
                attacksInfos.add(new AttacksInfo(attackId, _attack, degree));
            }
        }

        if (cursor != null) {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }
        return attacksInfos;
    }
}
