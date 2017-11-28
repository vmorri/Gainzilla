package com.project.section003.group1.gainzilla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "mainActivity";
    private static final String KEY = "workouts";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);






        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Workouts");
        myRef.setValue(WorkoutList.listworkouts);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("Database read error");
            }
        });

        Button start = (Button) findViewById(R.id.Start);
        Button addworkout = (Button) findViewById(R.id.add);

        List<Workout> WorkoutList = new ArrayList<Workout>();
        WorkoutList.add(new Workout());
        WorkoutList.get(0).changeName("testing");
        Log.d(TAG, "????");
        try {
            // Save the list of entries to internal storage
            InternalStorage.writeObject(this, KEY, WorkoutList);

            // Retrieve the list from internal storage
            List<Workout> WorkoutListRecall = (List<Workout>) InternalStorage.readObject(this, KEY);

            // Display the items from the list retrieved.
            for (Workout workout : WorkoutListRecall) {
                Log.d(TAG, workout.name);
                Log.d(TAG, "0000");
            }
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        } catch (ClassNotFoundException e) {
            Log.w(TAG, e.getMessage());
        }

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WorkoutActivity.class);
                startActivity(intent);
            }
        });
        addworkout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Exercise.class);
                startActivity(intent);
            }
        });

    }
}
