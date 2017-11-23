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

        //workout buttons
        int WLsize = WL.numWorkouts;
        Button workout1 = (Button) findViewById(R.id.workout1);
        Button workout2 = (Button) findViewById(R.id.workout2);
        Button workout3 = (Button) findViewById(R.id.workout3);
        Button workout4 = (Button) findViewById(R.id.workout4);
        Button workout5 = (Button) findViewById(R.id.workout5);
        Button workout6 = (Button) findViewById(R.id.workout6);
        Button workout7 = (Button) findViewById(R.id.workout7);
        if(WLsize == 0){
            workout1.setVisibility(View.GONE);
            workout2.setVisibility(View.GONE);
            workout3.setVisibility(View.GONE);
            workout4.setVisibility(View.GONE);
            workout5.setVisibility(View.GONE);
            workout6.setVisibility(View.GONE);
            workout7.setVisibility(View.GONE);
        }
        if(WLsize == 1){
            workout1.setText(WL.listworkouts.get(0).name);
            workout2.setVisibility(View.GONE);
            workout3.setVisibility(View.GONE);
            workout4.setVisibility(View.GONE);
            workout5.setVisibility(View.GONE);
            workout6.setVisibility(View.GONE);
            workout7.setVisibility(View.GONE);
        }
        if(WLsize == 2){
            workout1.setText(WL.listworkouts.get(0).name);
            workout2.setText(WL.listworkouts.get(1).name);
            workout3.setVisibility(View.GONE);
            workout4.setVisibility(View.GONE);
            workout5.setVisibility(View.GONE);
            workout6.setVisibility(View.GONE);
            workout7.setVisibility(View.GONE);
        }
        if(WLsize == 3) {
            workout1.setText(WL.listworkouts.get(0).name);
            workout2.setText(WL.listworkouts.get(1).name);
            workout3.setText(WL.listworkouts.get(2).name);
            workout4.setVisibility(View.GONE);
            workout5.setVisibility(View.GONE);
            workout6.setVisibility(View.GONE);
            workout7.setVisibility(View.GONE);
        }
        if(WLsize == 4) {
            workout1.setText(WL.listworkouts.get(0).name);
            workout2.setText(WL.listworkouts.get(1).name);
            workout3.setText(WL.listworkouts.get(2).name);
            workout4.setText(WL.listworkouts.get(3).name);
            workout5.setVisibility(View.GONE);
            workout6.setVisibility(View.GONE);
            workout7.setVisibility(View.GONE);
        }
        if(WLsize == 5) {
            workout1.setText(WL.listworkouts.get(0).name);
            workout2.setText(WL.listworkouts.get(1).name);
            workout3.setText(WL.listworkouts.get(2).name);
            workout4.setText(WL.listworkouts.get(3).name);
            workout5.setText(WL.listworkouts.get(4).name);
            workout6.setVisibility(View.GONE);
            workout7.setVisibility(View.GONE);
        }
        if(WLsize == 6) {
            workout1.setText(WL.listworkouts.get(0).name);
            workout2.setText(WL.listworkouts.get(1).name);
            workout3.setText(WL.listworkouts.get(2).name);
            workout4.setText(WL.listworkouts.get(3).name);
            workout5.setText(WL.listworkouts.get(4).name);
            workout6.setText(WL.listworkouts.get(5).name);
            workout7.setVisibility(View.GONE);
        }
        if(WLsize == 7) {
            workout1.setText(WL.listworkouts.get(0).name);
            workout2.setText(WL.listworkouts.get(1).name);
            workout3.setText(WL.listworkouts.get(2).name);
            workout4.setText(WL.listworkouts.get(3).name);
            workout5.setText(WL.listworkouts.get(4).name);
            workout6.setText(WL.listworkouts.get(5).name);
            workout6.setText(WL.listworkouts.get(6).name);
        }

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

            }
        });




    }
}
