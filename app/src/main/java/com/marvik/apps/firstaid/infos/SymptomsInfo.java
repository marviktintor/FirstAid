package com.marvik.apps.firstaid.infos;

/**
 * Created by victor on 9/1/2015.
 */
public class SymptomsInfo {
    int symptomId;
    String symptom;
    int attackId;

    public SymptomsInfo(int symptomId, String symptom, int attackId) {
        this.symptomId = symptomId;
        this.symptom = symptom;
        this.attackId = attackId;
    }

    public int getSymptomId() {
        return symptomId;
    }

    public String getSymptom() {
        return symptom;
    }

    public int getAttackId() {
        return attackId;
    }
}
