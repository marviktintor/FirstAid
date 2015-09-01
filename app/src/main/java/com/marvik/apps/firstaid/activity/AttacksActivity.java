package com.marvik.apps.firstaid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.marvik.apps.firstaid.R;
import com.marvik.apps.firstaid.adapters.AttacksListAdapter;
import com.marvik.apps.firstaid.customlist.AttacksCustomList;
import com.marvik.apps.firstaid.intents.Intents;
import com.marvik.apps.firstaid.utils.activities.ActivityWrapper;

import java.util.List;

/**
 * Created by victor on 9/1/2015.
 */
public class AttacksActivity extends ActivityWrapper implements AdapterView.OnItemClickListener, TextWatcher {

    private EditText etSearch;
    private ListView lvAttacks;

    private List<AttacksCustomList> attacksCustomLists;

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_attacks);
        if(getUtils().isFirstRun()){
            getUtils().initAttacksFirstAids();
        }
        initViews();

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


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();
        bundle.putInt(Intents.EXTRA_ATTACK_ID,attacksCustomLists.get(position).getAttackId());
        startActivity(new Intent(getApplicationContext(), ActivityFirstAid.class).putExtras(bundle));
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        populateListView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        populateListView();
    }


    private void initViews() {
        etSearch = (EditText) findViewById(R.id.activity_firstaid_editText_search);
        etSearch.addTextChangedListener(this);

        lvAttacks = (ListView) findViewById(R.id.activity_firstaid_listView_attacks);
        lvAttacks.setOnItemClickListener(this);
    }

    private void populateListView() {
        attacksCustomLists = getUtils().getTransactionsManager().getAttacksCustomList(etSearch.getText().toString());
        lvAttacks.setAdapter(new AttacksListAdapter(getApplicationContext(),R.layout.list_attacks,attacksCustomLists));
    }


}
