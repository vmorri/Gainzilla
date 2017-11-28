package com.project.section003.group1.gainzilla;

import android.os.Bundle;
import android.os.DropBoxManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by kikovinh on 11/28/2017.
 */

public class Graph extends AppCompatActivity{

    private static View.OnClickListener onClickListener;
    LineChart linechart;
    Exercise exercise;
    ArrayList<Exercise> exerciseSpec;
    ArrayList<Entry> entries;
    LineDataSet dataSet;

    public static void setOnClickListener(View.OnClickListener onClickListener) {
        Graph.onClickListener = onClickListener;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_workout);

        entries = new ArrayList<Entry>();

        //Make a list of exercises of one kind
        exerciseSpec = new ArrayList<Exercise>();

        //Starting benchmarks
        int weight = 45;
        int sets = 5;
        int reps = 5;



        //Make a span of 30 days of bench-press progression
        for(int i=0;i<30;i++){

            //Starting weight
            if(i==0){
                exercise = new Exercise("Bench-press", weight,sets, reps);
                exerciseSpec.add(exercise);
            }

            //Progression is random, but either increases or decreases up to 10lbs
            else{

                //For mocking purposes
                weight = new Random().nextInt(11) + weight;
                exercise = new Exercise("Bench-press", weight,sets, reps);
                exerciseSpec.add(exercise);
            }

            //Add to entries for graph
            entries.add(new Entry(i, weight));

        }

        //Generates the chart
        LineChart chart = (LineChart) findViewById(R.id.chart);
        LineDataSet dataSet = new LineDataSet(entries, "Bench-Press");
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh
    }
}
