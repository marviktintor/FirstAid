package com.marvik.apps.firstaid.database.tables;

/**
 * Created by victor on 9/1/2015.
 */
public class Tables {
    public static class Attacks {
        public static final String TABLE_NAME = "tbl_attacks";
        public static final String COL_ATTACK_ID = "attack_id";
        public static final String COL_ATTACK = "attack";
        public static final String COL_DEGREE = "degree";
        public static final String SQL = "CREATE TABLE IF NOT EXISTS " +TABLE_NAME +"("
                +COL_ATTACK_ID +" integer primary key autoincrement,"
                +COL_DEGREE +" integer,"
                +COL_ATTACK +" text not null);";
    }

    public static class Symptoms {
        public static final String TABLE_NAME = "tbl_symptoms";
        public static final String COL_ATTACK_ID = "attack_id";
        public static final String COL_SYMPTOM_ID = "symptom_id";
        public static final String COL_SYMPTOM = "symptom";

        public static final String SQL = "CREATE TABLE IF NOT EXISTS " +TABLE_NAME +"("
                +COL_SYMPTOM_ID +" integer primary key autoincrement,"
                +COL_SYMPTOM +" text not null,"
                +COL_ATTACK_ID +" integer);";

    }

    public static class FirstAids {
        public static final String TABLE_NAME = "tbl_firstaids";
        public static final String COL_ATTACK_ID = "attack_id";
        public static final String COL_FIRST_AID_ID = "first_aid_id";
        public static final String COL_FIRST_AID = "first_aid";
        public static final String SQL = "CREATE TABLE IF NOT EXISTS " +TABLE_NAME +"("
                +COL_FIRST_AID_ID +" integer primary key autoincrement,"
                +COL_FIRST_AID +" text not null,"
                +COL_ATTACK_ID +" integer);";
    }

    public static class Notes {
        public static final String TABLE_NAME = "tbl_notes";
        public static final String COL_ATTACK_ID = "attack_id";
        public static final String COL_NOTE_ID = "note_id";
        public static final String COL_NOTE = "note";
        public static final String SQL = "CREATE TABLE IF NOT EXISTS " +TABLE_NAME +"("
                +COL_NOTE_ID +" integer primary key autoincrement,"
                +COL_NOTE +" text not null,"
                +COL_ATTACK_ID +" integer);";
    }
}
