package com.example.assign3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {
    public DBhelper(Context context) {
        super(context,"Login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase Mydb) {
        Mydb.execSQL("create table users(username text primary key ,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Mydb, int i, int i1) {
        Mydb.execSQL("drop table if exists users");
    }
    public boolean checkusername(String user){
        SQLiteDatabase Mydb=getWritableDatabase();
        Cursor cursor=Mydb.rawQuery("select * from users where username=?",new String[]{user});
        if(cursor.getCount()>0) {
            return true;
        }else
            return false;
    }
    public Boolean inserdata (String user,String pass){
        SQLiteDatabase Mydb =getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password",pass);
        long result =Mydb.insert("users",null,contentValues);

        if (result>1)
            return true;
        else
            return false;
    }
}
