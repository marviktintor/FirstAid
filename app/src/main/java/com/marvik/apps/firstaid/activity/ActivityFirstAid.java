package com.marvik.apps.firstaid.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.marvik.apps.firstaid.R;
import com.marvik.apps.firstaid.infos.AttacksInfo;
import com.marvik.apps.firstaid.infos.FirstAidInfo;
import com.marvik.apps.firstaid.infos.NotesInfo;
import com.marvik.apps.firstaid.infos.SymptomsInfo;
import com.marvik.apps.firstaid.intents.Intents;
import com.marvik.apps.firstaid.utils.activities.ActivityWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victor on 9/1/2015.
 */
public class ActivityFirstAid extends ActivityWrapper implements AdapterView.OnItemSelectedListener {

    private List<String> degreesList;

    private List<AttacksInfo> attacksInfoList;
    private List<FirstAidInfo> firstAidInfoList;
    private List<SymptomsInfo> symptomsInfoList;
    private List<NotesInfo> notesInfoList;

    private Spinner spDegree;
    private TextView tvAttack;
    private TextView tvSymptoms;
    private TextView tvNotes;
    private TextView tvFirstAid;

    private int attackId;

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_first_aid);
        initViews();

        savedInstanceState = getIntent().getExtras();

        if (savedInstanceState != null) {
            if (savedInstanceState.getInt(Intents.EXTRA_ATTACK_ID) != -1) {
                attackId = savedInstanceState.getInt(Intents.EXTRA_ATTACK_ID);
                showFirstAidInfos(getAttackId());
            }
        }
    }

    private void showFirstAidInfos(int attackId) {

        attacksInfoList = getUtils().getTransactionsManager().getAttack(attackId);
        firstAidInfoList = getUtils().getTransactionsManager().getFirstAidInfoList(attackId);
        symptomsInfoList = getUtils().getTransactionsManager().getSymptomsInfoList(attackId);
        notesInfoList = getUtils().getTransactionsManager().getNotesInfoList(attackId);

        String attack = attacksInfoList.get(0).getAttack();
        if (attacksInfoList.get(0).getDegree() == -1) {
            spDegree.setVisibility(Spinner.GONE);
        }else{
            degreesList = new ArrayList<String>();
            degreesList.add("Degree " + attacksInfoList.get(0).getDegree());
            ArrayAdapter<String>adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_item,R.id.spinner_item_textView_label,degreesList);
            adapter.setDropDownViewResource(R.layout.spinner_item);
            spDegree.setAdapter(adapter);
        }
        String firstAid = "";
        for (int i = 0; i < firstAidInfoList.size(); i++) {
            firstAid += (i + 1) + " " + firstAidInfoList.get(i).getFirstAid() + "\r\n";
        }

        String symptoms = "";
        for (int i = 0; i < symptomsInfoList.size(); i++) {
            if(!symptomsInfoList.get(i).getSymptom().equals("")) {
                symptoms += (i + 1) + " " + symptomsInfoList.get(i).getSymptom() + "\r\n";
            }
        }

        String note = notesInfoList.get(0).getNote();


        tvAttack.setText(attack);
        tvSymptoms.setText(symptoms.equals("")?"The Person is Unconscious":symptoms);
        tvNotes.setText(note);
        tvFirstAid.setText(firstAid);
    }

    @Override
    protected void onResumeActivity() {

    }

    @Override
    protected void onPauseActivity() {

    }

    @Override
    protected void onDestroyActivity() {

    }

    public int getAttackId() {
        return attackId;
    }

    private void initViews() {
        spDegree = (Spinner) findViewById(R.id.activity_first_aid_spinner_degree);
        spDegree.setOnItemSelectedListener(this);


        tvAttack = (TextView) findViewById(R.id.activity_first_aid_textView_attack);
        tvSymptoms = (TextView) findViewById(R.id.activity_first_aid_textView_list_symptoms);
        tvNotes = (TextView) findViewById(R.id.activity_first_aid_textView_note);
        tvFirstAid = (TextView) findViewById(R.id.activity_first_aid_textView_list_first_aid);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //showFirstAidInfos(attacksInfoList.get(position).getAttackId());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
