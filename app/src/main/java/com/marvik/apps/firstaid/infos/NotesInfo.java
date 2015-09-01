package com.marvik.apps.firstaid.infos;

/**
 * Created by victor on 9/1/2015.
 */
public class NotesInfo {
    int noteId;
    String note;
    int attackId;

    public NotesInfo(int noteId, String note, int attackId) {
        this.noteId = noteId;
        this.note = note;
        this.attackId = attackId;
    }

    public int getNoteId() {
        return noteId;
    }

    public String getNote() {
        return note;
    }

    public int getAttackId() {
        return attackId;
    }
}
