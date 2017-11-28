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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.project.section003.group1.gainzilla.WorkoutList.listworkouts;

public class Exercise extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    EditText view_workout_name, view_name, view_weight, view_sets, view_reps;
    TextView view_database;
    String all_info; // String that has name, weight, sets, and reps of exercise
    Bundle bundle;
    Intent intent;
    ArrayList<String> itemList;
    Workout workout_new;
    int listsize = 0;


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
    MyDBHandler dbHandler;

    //Constructor (We assume we can only create once exercise if completely filled)

    public Exercise(){
        this._exname = " ";
        this._weight = 0;
        this._sets = 0;
        this._reps = 0;

    }

    public Exercise(String _workoutname, String _exname, float _weight, int _sets, int _reps){
        this._workoutname = _workoutname;
        this._exname = _exname;
        this._weight = _weight;
        this._sets = _sets;
        this._reps = _reps;
    }

    // Below methods allow database to retrieve the data
    public String getWorkoutName(){
        return this._workoutname;
    }

    public String getExName(){
        return this._exname;
    }

    public float getWeight(){
        return this._weight;
    }

    public int getSets(){
        return this._sets;
    }

    public int getReps(){
        return this._reps;
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        String[] items={""};
        itemList=new ArrayList<String>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(this,R.layout.list_items,R.id.txtview,itemList);
        workout_new = new Workout();


        //Initialize the list here once
        final List<Workout> workoutplans = new ArrayList<Workout>();


        ListView listV=findViewById(R.id.list);
        listV.setAdapter(adapter);

        view_name=findViewById(R.id.txtInput);
        view_weight=findViewById(R.id.txtInput2);
        view_sets=findViewById(R.id.txtInput3);
        view_reps=findViewById(R.id.txtInput4);
        view_workout_name=findViewById(R.id.txtInput5);
        view_database=findViewById(R.id.exerciseTable);

        //Creates the DB handler object
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();





        // ADD BUTTON
        Button btAdd=findViewById(R.id.btAdd);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all_info =("Workout Name: \t\t" + view_workout_name.getText().toString()+ "" +
                           "\n\nName: " + view_name.getText().toString() +
                           "\t\t\tWeight: " + view_weight.getText().toString() +
                           "\t\t\tSets: " + view_sets.getText().toString() +
                           "\t\t\tReps: " + view_reps.getText().toString()
                           + "\n\n");

                // add new item to arraylist
                itemList.add(all_info);

                // notify listview of data changed
                adapter.notifyDataSetChanged();

                ///** getting the value of edit text entered by user */
                intent = new Intent(Exercise.this, Workout.class);
                bundle = new Bundle();


                // Converts Android Text Format to correct data structures
                String workout_name = view_workout_name.getText().toString();
                String name = view_name.getText().toString();
                float weight = Float.parseFloat(view_weight.getText().toString());
                int sets = Integer.parseInt(view_sets.getText().toString());
                int reps = Integer.parseInt(view_reps.getText().toString());

                //Change the name of workout
                workout_new.changeName(workout_name);


                //Create exercise object
                Exercise exercise_new = new Exercise(workout_name, name, weight, sets, reps);

                // Add an exercise to workout
                workout_new.addExercise(exercise_new);

                // Add workout to workout list
                workoutplans.add(listsize,workout_new);





                dbHandler.addExerise(exercise_new);
                printDatabase();


                // sends the name, weight, sets, and reps value in their respective data types.
                bundle.putString("workout_name", workout_name);
                bundle.putString("name", name);
                bundle.putFloat("Weight", weight);
                bundle.putInt("sets", sets);
                bundle.putInt("reps", reps);
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

                //Creates a document with workout plan that points to a collection of exercises
                DocumentReference WorkoutRef = FirebaseFirestore.getInstance().document("Workouts/" + workout_name + "/Exercises/" + name);


                //Logs data into the database
                Map<String, Object> firebaseData = new HashMap<String, Object>();
                firebaseData.put(WEIGHT_KEY, weight);
                firebaseData.put(SETS_KEY, sets);
                firebaseData.put(REPS_KEY, reps);

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


    //printDatabase method
    public void printDatabase(){
        String dbString = dbHandler.DatabasetoString();
        view_database.setText(dbString);
    }

    @Override
    /*
    * Notifies the user that workout has been recorded
    * Saves workout under specific name to firebase*/
    public void onBackPressed() {
        Toast.makeText(this, "Your workout has been saved", Toast.LENGTH_SHORT).show();
        listsize += 1;
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

            }
        }, 4000);
        super.onBackPressed();
    }
}