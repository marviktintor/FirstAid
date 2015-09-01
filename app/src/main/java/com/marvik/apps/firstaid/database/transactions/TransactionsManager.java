package com.marvik.apps.firstaid.database.transactions;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.marvik.apps.firstaid.database.schemas.DatabaseSchema;
import com.marvik.apps.firstaid.infos.AttacksInfo;
import com.marvik.apps.firstaid.infos.FirstAidInfo;
import com.marvik.apps.firstaid.infos.NotesInfo;
import com.marvik.apps.firstaid.infos.SymptomsInfo;

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

    private Cursor attacksCursor,symptomsCursor,firstAidCursor,notesCursor;
    private SQLiteDatabase sqLiteDatabase;
    private DatabaseSchema databaseSchema;

    public TransactionsManager(Context context) {
        this.context = context;
        databaseSchema = new DatabaseSchema(getContext());
    }

    public Context getContext() {
        return context;
    }

    public List<AttacksInfo> getAttacksInfoList() {
        return attacksInfoList;
    }

    public List<SymptomsInfo> getSymptomsInfoList() {
        return symptomsInfoList;
    }

    public List<FirstAidInfo> getFirstAidInfoList() {
        return firstAidInfoList;
    }

    public List<NotesInfo> getNotesInfoList() {
        return notesInfoList;
    }

    public Cursor getAttacksCursor() {
        return attacksCursor;
    }

    public Cursor getSymptomsCursor() {
        return symptomsCursor;
    }

    public Cursor getFirstAidCursor() {
        return firstAidCursor;
    }

    public Cursor getNotesCursor() {
        return notesCursor;
    }

    public SQLiteDatabase getSqLiteDatabase() {
        if(sqLiteDatabase == null){
            sqLiteDatabase = databaseSchema.getReadableDatabase();
        }
        return sqLiteDatabase;
    }

    public DatabaseSchema getDatabaseSchema() {
        return databaseSchema;
    }
}
