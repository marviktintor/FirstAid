package com.marvik.apps.firstaid;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by victor on 9/1/2015.
 */
public class AttacksActivity extends Activity implements AdapterView.OnItemClickListener, TextWatcher {

    private EditText etSearch;
    private ListView lvAttacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attacks);

        initViews();
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
    @Override
    protected void onResume() {
        super.onResume();
        populateListView();
    }

    private void initViews() {
        etSearch = (EditText)findViewById(R.id.activity_firstaid_editText_search);
        etSearch.addTextChangedListener(this);

        lvAttacks = (ListView)findViewById(R.id.activity_firstaid_listView_attacks);
        lvAttacks.setOnItemClickListener(this);
    }

    private void populateListView() {
    }


}
