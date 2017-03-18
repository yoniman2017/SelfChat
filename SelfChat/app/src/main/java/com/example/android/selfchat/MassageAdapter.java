package com.example.android.selfchat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yoni on 3/18/2017.
 */

public class MassageAdapter extends RecyclerView.Adapter<MassageAdapter.massgeHolder> {
    public static class massgeHolder extends RecyclerView.ViewHolder {

        private TextView massage;

        public massgeHolder(View v) {
            super(v);
            massage = (TextView) v.findViewById(R.id.item);
        }
    }

    private ArrayList<String> masseges;
    private static int pos = 0;

    public MassageAdapter(ArrayList<String> masseges) {
        this.masseges = masseges;
    }


    @Override
    public massgeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.massage, parent, false);
        return new massgeHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(massgeHolder holder, int position) {
        String massage = masseges.get(pos++);
        holder. massage.setText(massage);
    }

    @Override
    public int getItemCount() {
        return masseges.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public void notifyData(ArrayList<String> masseges) {
        this.masseges = masseges;
        notifyDataSetChanged();
    }

}
