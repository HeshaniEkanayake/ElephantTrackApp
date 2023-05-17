package com.example.elephanttrackapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query1="create table User(username text,email text,password text)";
        String query2="create table Elephant(elephantId text,deviceId text)";
        sqLiteDatabase.execSQL(query1);
        sqLiteDatabase.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void register(String name,String email,String password){
        ContentValues cv=new ContentValues();
        cv.put("username",name);
        cv.put("email",email);
        cv.put("password",password);

        SQLiteDatabase db=getWritableDatabase();
        db.insert("User",null,cv);
        db.close();
    }

    public int login(String username,String password){
        int result=0;
        String str[]=new String[2];
        str[0]=username;
        str[1]=password;
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("select * from User where username=? and password=? ",str);
        if(c.moveToFirst()){
            result=1;
        }
        return result;
    }

    public ArrayList<String>getUsers(){
        ArrayList<String> list=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        

        return list;
    }







}
