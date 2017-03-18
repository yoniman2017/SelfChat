package com.example.android.selfchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText textInput;
    private Button buttunSend;
    private RecyclerView listMassages;
    private ArrayList<String> massages;
    private MassageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInput = (EditText) findViewById(R.id.editText);
        buttunSend = (Button) findViewById(R.id.button);
        massages = new ArrayList<>(10);

        listMassages = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new MassageAdapter(massages);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        listMassages.setLayoutManager(mLayoutManager);
        listMassages.setItemAnimator(new DefaultItemAnimator());
        listMassages.setAdapter(adapter);


        textInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND){
                    addRow(v);
                    return true;
                }
                return false;
            }
        });
        buttunSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRow(textInput);
            }
        });
    }

    private void addRow(TextView v) {
        massages.add(v.getText().toString());
        v.setText("");
        adapter.notifyData(massages);
    }
}
