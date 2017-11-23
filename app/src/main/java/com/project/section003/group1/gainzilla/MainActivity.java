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
    public ListView lv;
    public WorkoutList WL = new WorkoutList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = (Button) findViewById(R.id.Start);
        Button addworkout = (Button) findViewById(R.id.add);
        int WLsize = WL.numWorkouts;
        if(WLsize >= 1){
            Button workout1 = (Button) findViewById(R.id.One);
        }

        /*
        //create workout
        lv = (ListView) findViewById(R.id.addExerList);
        List<Exercise> your_array_list = WL.currentWorkout.ex;
        ArrayAdapter<Exercise> arrayAdapter = new ArrayAdapter<Exercise>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );
        lv.setAdapter(arrayAdapter);

        */


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




    }
}
