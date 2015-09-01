package com.marvik.apps.firstaid.infos;

/**
 * Created by victor on 9/1/2015.
 */
public class FirstAidInfo {

    int firstAidId;
    String firstAid;
    int attackId;

    public FirstAidInfo(int firstAidId, String firstAid, int attackId) {

        this.firstAidId = firstAidId;
        this.firstAid = firstAid;
        this.attackId = attackId;
    }

    public int getFirstAidId() {
        return firstAidId;
    }

    public String getFirstAid() {
        return firstAid;
    }

    public int getAttackId() {
        return attackId;
    }
}
