package com.marvik.apps.firstaid.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.marvik.apps.firstaid.R;
import com.marvik.apps.firstaid.utils.activities.ActivityWrapper;

import java.util.ArrayList;

/**
 * Created by victor on 9/2/2015.
 */
public class ActivityEmergencySupport extends ActivityWrapper implements AdapterView.OnItemClickListener {
    private ListView lvEmergencyAndSupport;

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_emergency_and_support);
        initChildViews();
    }

    private void initChildViews() {
        lvEmergencyAndSupport = (ListView) findViewById(R.id.activity_emergency_and_support_listView_emergency_and_support);
        lvEmergencyAndSupport.setOnItemClickListener(this);

        ArrayList<String> emergencyAndSupport = new ArrayList<String>();


        emergencyAndSupport.add("Purchase a first aid kit");
        emergencyAndSupport.add("Get emergency medical unit");
        emergencyAndSupport.add("Nearest hospital to you");
        emergencyAndSupport.add("Ask a doctor");
        emergencyAndSupport.add(" Report a medical issue");
        emergencyAndSupport.add("Get check-up and testing");

        lvEmergencyAndSupport.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.list_emergency_and_support, R.id.list_emergency_and_support_textView_item, emergencyAndSupport));

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
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.country_firestation_tel))));
    }
}
