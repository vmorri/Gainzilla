package com.project.section003.group1.gainzilla;

import android.net.wifi.p2p.WifiP2pManager;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import java.lang.ref.WeakReference;


public class Exercise extends AppCompatActivity {

    Button mButton;
    EditText mEdit;
    TextView mText;
    //
    EditText mEdit2;
    TextView mText2;
    //
    EditText mEdit3;
    TextView mText3;
    //
    EditText mEdit4;
    TextView mText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

    }

    public void buttonClicked(View v){
        Button mButton = (Button) findViewById(R.id.createButton);

        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mEdit   = (EditText)findViewById(R.id.textInputEditText);
                String mEdit = ((EditText) findViewById(R.id.textInputEditText)).getText().toString();
                mText = (TextView)findViewById(R.id.textInputEditText);
                mText.setText("qqqqq");
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mEdit2   = (EditText)findViewById(R.id.textInputEditText3);
                String mEdit = ((EditText) findViewById(R.id.textInputEditText3)).getText().toString();
                mText2 = (TextView)findViewById(R.id.textInputEditText3);
                mText2.setText("qqqqq");
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mEdit3   = (EditText)findViewById(R.id.textInputEditText2);
                String mEdit = ((EditText) findViewById(R.id.textInputEditText2)).getText().toString();
                mText3 = (TextView)findViewById(R.id.textInputEditText2);
                mText3.setText("qqqqq");
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mEdit4   = (EditText)findViewById(R.id.textInputEditText4);
                String mEdit = ((EditText) findViewById(R.id.textInputEditText4)).getText().toString();
                mText4 = (TextView)findViewById(R.id.textInputEditText4);
                mText4.setText("qqqqq");
            }
        });

    }
    }
