package com.example.medicalreminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseConn extends SQLiteOpenHelper {
    public DataBaseConn(Context context){
        super(context,"Medicinedb",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table MDTable (MedicineName text, Date text, Time text) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insertValues(String medname, String meddate, String medtime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MedicineName",medname);
        contentValues.put("Date",meddate);
        contentValues.put("Time",medtime);
        long res = db.insert("MDTable",null,contentValues);
        if(res==-1) return false;
        else return true;
    }

    public Cursor fetchData(String date, String time){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select * from MDTable where date ='" + date + "' AND time = '" + time + "'" ,null);
        return c;
    }
}
