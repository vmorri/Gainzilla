package com.project.section003.group1.gainzilla;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private WorkoutList WL = new WorkoutList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = (Button) findViewById(R.id.Start);
        Button addworkout = (Button) findViewById(R.id.add);

        //workout buttons
        int WLsize = WL.workouts.size();
        Button workout1 = (Button) findViewById(R.id.workout1);
        Button workout2 = (Button) findViewById(R.id.workout2);
        Button workout3 = (Button) findViewById(R.id.workout3);
        if(WLsize == 0){
            workout1.setVisibility(View.GONE);
            workout2.setVisibility(View.GONE);
            workout3.setVisibility(View.GONE);
        }
        if(WLsize == 1){
            workout1.setText(WL.workouts.get(0).name);
            workout2.setVisibility(View.GONE);
            workout3.setVisibility(View.GONE);
        }
        if(WLsize == 2){
            workout1.setText(WL.workouts.get(0).name);
            workout2.setText(WL.workouts.get(1).name);
            workout3.setVisibility(View.GONE);
        }
        if(WLsize == 3){
            workout1.setText(WL.workouts.get(0).name);
            workout2.setText(WL.workouts.get(1).name);
            workout3.setText(WL.workouts.get(2).name);
        }
        //create workout
        lv = (ListView) findViewById(R.id.addExerList);
        List<Exercise> your_array_list = WL.currentWorkout.ex;
        ArrayAdapter<Exercise> arrayAdapter = new ArrayAdapter<Exercise>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );
        lv.setAdapter(arrayAdapter);

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setContentView(R.layout.workout);
            }
        });
        addworkout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setContentView(R.layout.add);
            }
        });
        workout1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WL.currentWorkout = WL.workouts.get(0);
            }
        });




    }
}
