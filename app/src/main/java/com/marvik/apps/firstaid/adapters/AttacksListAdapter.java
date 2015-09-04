package com.marvik.apps.firstaid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.marvik.apps.firstaid.R;
import com.marvik.apps.firstaid.customlist.AttacksCustomList;

import java.util.List;

/**
 * Created by victor on 9/1/2015.
 */
public class AttacksListAdapter extends BaseAdapter {

    private Holder holder;

    private Context context;
    private int layout;
    private List<AttacksCustomList> attacksCustomLists;

    public AttacksListAdapter(Context context, int layout, List<AttacksCustomList> attacksCustomLists) {
        this.context = context;
        this.layout = layout;
        this.attacksCustomLists = attacksCustomLists;
    }

    public Context getContext() {
        return context;
    }

    public int getLayout() {
        return layout;
    }

    public List<AttacksCustomList> getAttacksCustomLists() {
        return attacksCustomLists;
    }

    @Override
    public int getCount() {
        return getAttacksCustomLists().size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class Holder {
        private TextView tvAttack, tvSymptoms;

        Holder(View attacksView) {
            tvAttack = (TextView) attacksView.findViewById(R.id.list_attacks_textView_attack);
            tvSymptoms = (TextView) attacksView.findViewById(R.id.list_attacks_textView_symptoms);
        }

        public void setAttack(int position) {
            tvAttack.setText(getAttacksCustomLists().get(position).getAttack());
        }

        public void setSymptoms(int position) {
            String symptoms = getAttacksCustomLists().get(position).getSymptom();
            tvSymptoms.setText(symptoms.equals("")?"The Person is Unconscious":symptoms);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View attacksView = convertView;
        if (attacksView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            attacksView = layoutInflater.inflate(getLayout(), parent, false);

            holder = new Holder(attacksView);
            attacksView.setTag(holder);
        }

        holder = (Holder) attacksView.getTag();
        holder.setAttack(position);
        holder.setSymptoms(position);
        return attacksView;
    }


}
