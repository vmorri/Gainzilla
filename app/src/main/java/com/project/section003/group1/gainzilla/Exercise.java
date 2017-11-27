package com.project.section003.group1.gainzilla;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.project.section003.group1.gainzilla.WorkoutList.listworkouts;

public class Exercise extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    EditText workout_name, name, weight, sets, reps;
    String all_info; // String that has name, weight, sets, and reps of exercise
    Bundle bundle;
    Intent intent;
    ArrayList<String> itemList;


    //////// Firestore variables////////////////////
    public static final String WORKOUT_KEY = "name";
    public static final String NAME_KEY = "name";
    public static final String WEIGHT_KEY = "weight";
    public static final String SETS_KEY = "sets";
    public static final String REPS_KEY = "reps";
    ///////////////////////////////////////////////




    //SQL LITE Attempt
    private String _workoutname;
    private String _exname;
    private float _weight;
    private int _sets;
    private int _reps;

    //Constructor (We assume we can only create once exercise if completely filled)
    public Exercise(String _workoutname, String _exname, float _weight, int _sets, int _reps){
        this._workoutname = _workoutname;
        this._exname = _exname;
        this._weight = _weight;
        this._sets = _sets;
        this._reps = _reps;
    }


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
                all_info =("Workout Name: \t\t" + workout_name.getText().toString()+ "\n\nName: " + name.getText().toString() + "\t\t\tWeight: " + weight.getText().toString()
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


                /*Firebase related code
                *
                *  In Firebase Cloud storage, data is organized into documents and collections. Collections
                *  are not able to contain any data except for documents and documents are the only ones that contain
                *  strings, ints, etc. However, documents can link to subsections. For reference sake, the order works
                *  where the first directory is the root and is a collection
                *
                *  Workouts/"NameofWorkout"/Exercise/"NameofExercise"
                *
                * */

                //Names the new collection ("workout")
                String planRef = workout_name.getText().toString();
                String nameRef = name.getText().toString();

                //Creates a document with workout plan that points to a collection of exercises
                DocumentReference WorkoutRef = FirebaseFirestore.getInstance().document("Workouts/" + planRef + "/Exercises/" + nameRef);


                //Logs data into the database
                Map<String, Object> firebaseData = new HashMap<String, Object>();
                firebaseData.put(WEIGHT_KEY, Float.parseFloat(weight.getText().toString()));
                firebaseData.put(SETS_KEY, Integer.parseInt(sets.getText().toString()));
                firebaseData.put(REPS_KEY, Integer.parseInt(reps.getText().toString()));

                //Checks if data passed was successful
                WorkoutRef.set(firebaseData).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("Exercise", "Exercise has been saved");
                    }
                });
















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