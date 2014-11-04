package com.example.employeemanager;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

public class DBHelper extends SQLiteOpenHelper {

 final static String dbname = "Employeemanager";
 SQLiteDatabase db;
String pass;
 public DBHelper(Context context) {
  super(context, dbname, null, 1);
  // TODO Auto-generated constructor stub
 }

 public void table1() {

  db = this.getWritableDatabase();
  


  //db.execSQL("CREATE TABLE IF NOT EXISTS tab(id INTEGER PRIMARY KEY AUTOINCREMENT , description TEXT)");
   db.execSQL("CREATE TABLE IF NOT EXISTS Employee(fullname VARCHAR,dob DATE,mstatus VARCHAR,gender VARCHAR,nationality VARCHAR);");
  // to see colomn names in our table1
  Cursor t = db.rawQuery("PRAGMA TABLE_INFO(tab)", null);
  if (t.moveToFirst()) {
   do {
    Log.i("", t.getString(0) + " " + t.getString(1));
   } while (t.moveToNext());
  }
  t.close();
  db.close();

 }

 public void inserIntoTable1(String desc) {
pass=desc;
   db = this.getWritableDatabase();
  ContentValues cv = new ContentValues();
  try {
   db.beginTransaction();
   cv.put("description", desc);
  
   Cursor c = db.rawQuery("SELECT  fname  from Employee Where username='"+ pass+ "' ",null);
   c.moveToFirst();
   //db.insert(" Employee", null, cv);
  // db.setTransactionSuccessful();

  } catch (Exception ex) {

  } finally {
   db.endTransaction();
   db.close();
  }
 }

 public List<String> getData()
 {
	 
  db = this.getReadableDatabase();
  List<String> data = new ArrayList<String>();
  Cursor c = db.rawQuery("SELECT * FROM  Employee", null);
  while (c.moveToNext()) {
   data.add(c.getString(3));
   
  }
  c.close();
  db.close();
  return data;
 }

 @Override
 public void onCreate(SQLiteDatabase db) {
 }

 @Override
 public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
  // TODO Auto-generated method stub

 }
}
 