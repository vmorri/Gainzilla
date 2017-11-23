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
    Button workoutOne = (Button) findViewById(R.id.workout1);
    Button workoutTwo = (Button) findViewById(R.id.workout2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = (Button) findViewById(R.id.Start);
        Button addworkout = (Button) findViewById(R.id.add);

        //workout buttons
        int WLsize = WL.numWorkouts;

        /*Button workoutThree = (Button) findViewById(R.id.workout3);
        Button workoutFour = (Button) findViewById(R.id.workout4);
        Button workoutFive = (Button) findViewById(R.id.workout5);
        Button workoutSix = (Button) findViewById(R.id.workout6);
        Button workoutSeven = (Button) findViewById(R.id.workout7);*/
        if(WLsize == 0){
            workoutOne.setVisibility(View.GONE);
            workoutTwo.setVisibility(View.GONE);
            /*workoutThree.setVisibility(View.GONE);
            workoutFour.setVisibility(View.GONE);
            workoutFive.setVisibility(View.GONE);
            workoutSix.setVisibility(View.GONE);
            workoutSeven.setVisibility(View.GONE);*/
        }
        if(WLsize == 1){
            workoutOne.setText(WL.listworkouts.get(0).name);
            workoutTwo.setVisibility(View.GONE);
           /* workoutThree.setVisibility(View.GONE);
            workoutFour.setVisibility(View.GONE);
            workoutFive.setVisibility(View.GONE);
            workoutSix.setVisibility(View.GONE);
            workoutSeven.setVisibility(View.GONE);*/
        }
        if(WLsize == 2){
            workoutOne.setText(WL.listworkouts.get(0).name);
            workoutTwo.setText(WL.listworkouts.get(1).name);}
           /* workoutThree.setVisibility(View.GONE);
            workoutFour.setVisibility(View.GONE);
            workoutFive.setVisibility(View.GONE);
            workoutSix.setVisibility(View.GONE);
            workoutSeven.setVisibility(View.GONE);
        }
        if(WLsize == 3) {
            workoutOne.setText(WL.listworkouts.get(0).name);
            workoutTwo.setText(WL.listworkouts.get(1).name);
            workoutThree.setText(WL.listworkouts.get(2).name);
            workoutFour.setVisibility(View.GONE);
            workoutFive.setVisibility(View.GONE);
            workoutSix.setVisibility(View.GONE);
            workoutSeven.setVisibility(View.GONE);
        }
        if(WLsize == 4) {
            workoutOne.setText(WL.listworkouts.get(0).name);
            workoutTwo.setText(WL.listworkouts.get(1).name);
            workoutThree.setText(WL.listworkouts.get(2).name);
            workoutFour.setText(WL.listworkouts.get(3).name);
            workoutFive.setVisibility(View.GONE);
            workoutSix.setVisibility(View.GONE);
            workoutSeven.setVisibility(View.GONE);
        }
        if(WLsize == 5) {
            workoutOne.setText(WL.listworkouts.get(0).name);
            workoutTwo.setText(WL.listworkouts.get(1).name);
            workoutThree.setText(WL.listworkouts.get(2).name);
            workoutFour.setText(WL.listworkouts.get(3).name);
            workoutFive.setText(WL.listworkouts.get(4).name);
            workoutSix.setVisibility(View.GONE);
            workoutSeven.setVisibility(View.GONE);
        }
        if(WLsize == 6) {
            workoutOne.setText(WL.listworkouts.get(0).name);
            workoutTwo.setText(WL.listworkouts.get(1).name);
            workoutThree.setText(WL.listworkouts.get(2).name);
            workoutFour.setText(WL.listworkouts.get(3).name);
            workoutFive.setText(WL.listworkouts.get(4).name);
            workoutSix.setText(WL.listworkouts.get(5).name);
            workoutSeven.setVisibility(View.GONE);
        }
        if(WLsize == 7) {
            workoutOne.setText(WL.listworkouts.get(0).name);
            workoutTwo.setText(WL.listworkouts.get(1).name);
            workoutThree.setText(WL.listworkouts.get(2).name);
            workoutFour.setText(WL.listworkouts.get(3).name);
            workoutFive.setText(WL.listworkouts.get(4).name);
            workoutSix.setText(WL.listworkouts.get(5).name);
            workoutSeven.setText(WL.listworkouts.get(6).name);
        }*/

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setContentView(R.layout.workout);
            }
        });
        addworkout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setContentView(R.layout.activity_exercise);
            }
        });
        workoutOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setContentView(R.layout.add);
            }
        });

        



    }
}
