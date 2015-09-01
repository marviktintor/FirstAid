package com.marvik.apps.firstaid.infos;

/**
 * Created by victor on 9/1/2015.
 */
public class AttacksInfo {
    int attackId;
    String attack;
    int degree;

    public AttacksInfo(int attackId, String attack, int degree) {
        this.attackId = attackId;
        this.attack = attack;
        this.degree = degree;
    }

    public int getAttackId() {
        return attackId;
    }

    public String getAttack() {
        return attack;
    }

    public int getDegree() {
        return degree;
    }
}
