package com.project.section003.group1.gainzilla;

import android.net.wifi.p2p.WifiP2pManager;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.ArrayList;


public class Exercise extends AppCompatActivity {

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

    }
*/
    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;

    Button addButton;
    ListView listView;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        editText = (EditText) findViewById(R.id.textInputEditText);
        editText2 = (EditText) findViewById(R.id.textInputEditText2);
        editText3 = (EditText) findViewById(R.id.textInputEditText3);
        editText4 = (EditText) findViewById(R.id.textInputEditText4);


        addButton = (Button) findViewById(R.id.createButton);
        listView = (ListView) findViewById(R.id.exList);

        listItems = new ArrayList<>();
        listItems.add(editText);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);
        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                listItems.add(editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {
                Toast.makeText(Exercise.this, "Clicked", Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}



