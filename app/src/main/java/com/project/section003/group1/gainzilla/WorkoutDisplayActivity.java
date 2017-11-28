package com.project.section003.group1.gainzilla;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkoutDisplayActivity extends AppCompatActivity {
    private ListView lv;
    final Context context = this;
    private Button button;
    private EditText result;
    private static final String TAG = "mainActivity";
    private static final String KEY = "workouts";
    public List<Workout> workoutplans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_display);

        try {
            // Retrieve the list from internal storage
            workoutplans = (List<Workout>) InternalStorage.readObject(this, KEY);

            // Display the items from the list retrieved.
            for (Workout workout : workoutplans) {
                Log.d(TAG, workout.name);
            }
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        } catch (ClassNotFoundException e) {
            Log.w(TAG, e.getMessage());
        }

        Intent intent = getIntent();
        String message = intent.getStringExtra(WorkoutActivity.EXTRA_MESSAGE);
        final int workoutNum = Integer.parseInt(message);

        lv = (ListView) findViewById(R.id.exerList3);
        List<Exercise> your_array_list = workoutplans.get(workoutNum -1).ex;
        final ArrayAdapter<Exercise> arrayAdapter = new ArrayAdapter<Exercise>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.weight_prompt, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextInput);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        // get user input and set it to result
                                        // edit weight
                                        workoutplans.get(workoutNum - 1).ex.get(position).setWeight(userInput.getText());
                                        arrayAdapter.notifyDataSetChanged();
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });

    }

}
