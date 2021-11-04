package com.example.assignmentandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    public dbHelper(Context context) {
        super(context, "users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("CREATE TABLE USERS(username text primary key," +
                "password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS USERS");
    }

    //OPERATIONS

    public Boolean insertuserdata(String username,String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
       contentValues.put("username",username);
//        contentValues.put("gender",gender);
//        contentValues.put("idNumber",idNumber);
//        contentValues.put("address",address);
        contentValues.put("password",password);
//        contentValues.put("fullname",fullname);

        long result=DB.insert("USERS",null,contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }

    }

//    //Login
//    public Cursor getdata(String username){
//        SQLiteDatabase DB=this.getWritableDatabase();
//
//        Cursor cursor=DB.rawQuery("Select * from USERS where username=?", new String[] {username});
//        if (cursor != null) {
//            cursor.moveToFirst();
//        }
//        return cursor;
//
//
//    }

    public Boolean checkUser(String username, String password) {
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * from USERS where username = ? and password = ?",
                new String[] {username,password});
        if(cursor.getCount() >0) {
            return true;
        }else{
            return false;
        }
    }


}
