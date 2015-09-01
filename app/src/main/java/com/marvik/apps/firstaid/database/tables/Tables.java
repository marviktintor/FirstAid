package com.marvik.apps.firstaid.database.tables;

/**
 * Created by victor on 9/1/2015.
 */
public class Tables {
    public static class Attacks {
        public static final String COL_ATTACK_ID = "attack_id";
        public static final String COL_ATTACK = "attack";

    }

    public static class Symptoms {
        public static final String COL_ATTACK_ID = "attack_id";
        public static final String COL_SYMPTOM_ID = "symptom_id";
        public static final String COL_SYMPTOM = "symptom";
    }

    public static class FirstAids {
        public static final String COL_ATTACK_ID = "attack_id";
        public static final String COL_FIRST_AID_ID = "first_aid_id";
        public static final String COL_FIRST_AID = "first_aid";
    }

    public static class Notes {
        public static final String COL_ATTACK_ID = "attack_id";
        public static final String COL_NOTE_ID = "note_id";
        public static final String COL_NOTE = "note";
    }
}
