package com.project.section003.group1.gainzilla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class WorkoutDisplayActivity extends AppCompatActivity {
    ArrayAdapter<Exercise> adapter;
    ArrayList<Exercise> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_disp);

        Intent intent = getIntent();
        String message = intent.getStringExtra(WorkoutActivity.EXTRA_MESSAGE);
        int workoutNum = Integer.parseInt(message);
        String[] items={""};
        //itemList=new ArrayList<String>(Arrays.asList(items));
        adapter=new ArrayAdapter<Exercise>(this, android.R.layout.simple_list_item_1, WorkoutList.listworkouts.get(workoutNum -1).ex);

        ListView LV=(ListView)findViewById(R.id.exerList);
        LV.setAdapter(adapter);
    }

}
