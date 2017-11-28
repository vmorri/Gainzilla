package com.project.section003.group1.gainzilla;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

/**
 * Created by kikovinh on 11/27/2017.
 */

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "gainzilla.db";
    public static final String TABLE_EXERCISES = "exercisesTable";
    public static final String COLUMN_WORKOUTNAME = "workoutname";
    public static final String COLUMN_EXERCISENAME = "exercisename";
    public static final String COLUMN_WEIGHT = "weight";
    public static final String COLUMN_SETS = "sets";
    public static final String COLUMN_REPS = "reps";

    //Need to pass information for dataase
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_EXERCISES + "(" +
                COLUMN_WORKOUTNAME + " TEXT " +
                COLUMN_EXERCISENAME + " TEXT " +
                COLUMN_WEIGHT + " FLOAT " +
                COLUMN_SETS + " INTEGER " +
                COLUMN_REPS + " INTEGER" +
                ");";

        db.execSQL(query);
    }


    //Occurs whenever the database goes through a big change
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISES);
        onCreate(db);
    }

    //Add an exercise to Database
    public void addExerise(Exercise exercise){
        ContentValues values = new ContentValues();
        values.put(COLUMN_WORKOUTNAME, exercise.getWorkoutName());
        values.put(COLUMN_EXERCISENAME, exercise.getExName());
        values.put(COLUMN_WEIGHT, exercise.getWeight());
        values.put(COLUMN_SETS, exercise.getSets());
        values.put(COLUMN_REPS, exercise.getReps());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_EXERCISES, null, values);
        db.close();
    }

    public String DatabasetoString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EXERCISES + " WHERE 1";

        //Cursor to point
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("workoutname"))!=null){
                dbString += c.getString(c.getColumnIndex("workoutname"));
                dbString += "\n";
            }
        }
        db.close();
        return dbString;
    }

    //Delete an exercise from the Database

}
