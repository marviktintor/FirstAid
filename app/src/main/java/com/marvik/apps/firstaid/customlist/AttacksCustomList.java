package com.marvik.apps.firstaid.customlist;

/**
 * Created by victor on 9/1/2015.
 */
public class AttacksCustomList {
    int attackId;
    String attack, symptom;

    public AttacksCustomList(int attackId, String attack, String symptom) {
        this.attackId = attackId;
        this.attack = attack;
        this.symptom = symptom;
    }

    public int getAttackId() {
        return attackId;
    }

    public String getAttack() {
        return attack;
    }

    public String getSymptom() {
        return symptom;
    }
}
