package com.project.section003.group1.gainzilla;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    EditText workout_name, name, weight, sets, reps;
    String all_info; // String that has name, weight, sets, and reps of exercise
    Bundle bundle;
    Intent intent;
    ArrayList<String> itemList;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        String[] items={""};
        itemList=new ArrayList<String>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(this,R.layout.list_items,R.id.txtview,itemList);

        ListView listV=findViewById(R.id.list);
        listV.setAdapter(adapter);

        name=findViewById(R.id.txtInput);
        weight=findViewById(R.id.txtInput2);
        sets=findViewById(R.id.txtInput3);
        reps=findViewById(R.id.txtInput4);
        workout_name=findViewById(R.id.txtInput5);

        Button btAdd=findViewById(R.id.btAdd);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all_info =("Workout Name: \n\n" + name.getText().toString()+ "Name: " + name.getText().toString() + "\t\t\tWeight: " + weight.getText().toString()
                        + "\t\t\tSets: " + sets.getText().toString() + "\t\t\tReps: " + reps.getText().toString() + "\n\n");
                // add new item to arraylist
                itemList.add(all_info);
                // notify listview of data changed
                adapter.notifyDataSetChanged();

                ///** getting the value of edit text entered by user */
                intent = new Intent(Exercise.this, Workout.class);
                bundle = new Bundle();
                // sends the name, weight, sets, and reps value in their respective data types.
                bundle.putString("workout_name", workout_name.getText().toString());
                bundle.putString("name", name.getText().toString());
                bundle.putFloat("Weight",Float.parseFloat(weight.getText().toString()));
                bundle.putInt("sets", Integer.parseInt(sets.getText().toString()));
                bundle.putInt("reps", Integer.parseInt(reps.getText().toString()));
                ///** start Activity2 */
                //startActivity(intent);
            }
        });
    }

    @Override
    /*
    * Notifies the user that workout has been recorded
    * Saves workout under specific name to firebase*/
    public void onBackPressed() {
        Toast.makeText(this, "Your workout has been saved", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

            }
        }, 4000);
        super.onBackPressed();
    }
}