package com.project.section003.group1.gainzilla;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Exercise extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    String newItem;
    Bundle bundle;
    Intent intent;

    ArrayList<String> itemList;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        String[] items={""};
        itemList=new ArrayList<String>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(this,R.layout.list_items,R.id.txtview,itemList);

        ListView listV=(ListView)findViewById(R.id.list);
        listV.setAdapter(adapter);

        editText=(EditText)findViewById(R.id.txtInput);
        editText2=(EditText)findViewById(R.id.txtInput2);
        editText3=(EditText)findViewById(R.id.txtInput3);
        editText4=(EditText)findViewById(R.id.txtInput4);


        Button btAdd=(Button)findViewById(R.id.btAdd);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newItem=("Name:" + editText.getText().toString() + "     Weight:" + editText2.getText().toString() + "        Sets:" + editText3.getText().toString() + "         Reps:" + editText4.getText().toString() + "");
                // add new item to arraylist
                itemList.add(newItem);
                // notify listview of data changed
                adapter.notifyDataSetChanged();

                /** getting the value of edit text entered by user */
                String exercise_to_pass = newItem;
                Intent intent = new Intent(Exercise.this, Workout.class);

                /** setting the textVal in intentExtra */
                /** passing string */
                bundle = new Bundle();
                bundle.putString("exercise_to_pass", exercise_to_pass);

                /** passing string array*/
                // bundle.putStringArray("array", arr);
                // intent.putExtras(bundle);

                /** start Activity2 */
                startActivity(intent);
            }
        });

    }


}