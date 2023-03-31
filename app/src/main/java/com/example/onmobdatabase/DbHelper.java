package com.example.onmobdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "INFO";
    public static final String DB_TABLE = "CRED";
    public static final Integer DB_VERSION = 1;
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PASS = "pass";



    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String create = "CREATE TABLE " + DB_TABLE
                + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_NAME + " TEXT, "
                + KEY_PASS + " TEXT)";
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void save(Data data){
        // this will open the database in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // this is responsible to write the contents
        ContentValues value = new ContentValues();
        value.put(KEY_NAME, data.getName());
        value.put(KEY_PASS, data.getPass());

        db.insert(DB_TABLE, null, value);
//        Log.d("insertion", "complete");
    }

    public List<Data> fetch(){
        List<Data> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM " + DB_TABLE;
        Cursor point = db.rawQuery(select, null);

        if(point.moveToFirst()){
            do{
                Data d = new Data();
                d.setName(point.getString(1));
                d.setPass(point.getString(2));
                data.add(d);
            }while(point.moveToNext());
        }
        return data;
    }
}
