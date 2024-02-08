package com.example.librarymgmtsystem;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
public class DB extends SQLiteOpenHelper {
SQLiteDatabasesqLiteDatabase;
public DB( Context context) {
super(context, "data.db", null, 1);
sqLiteDatabase=getWritableDatabase();
}
@Override
public void onCreate(SQLiteDatabasesqLiteDatabase) {
sqLiteDatabase.execSQL("create table bookinsert(BookNametext,author
text)");
}
@Override
public void onUpgrade(SQLiteDatabasesqLiteDatabase, inti, int i1) {
onCreate(sqLiteDatabase);

}
public void sav(String s, String s1) {
ContentValues cv=new ContentValues();
cv.put("BookName",s);
cv.put("author",s1);
sqLiteDatabase.insert("bookinsert",null,cv);
}
public String retrieve(String s3) {
Cursor c=sqLiteDatabase.query("bookinsert",null,"BookName=?",new
String[]{s3},null,null,null);
c.moveToFirst();
if(c.getCount()<=0)
{
return "does not exist";
}
@SuppressLint("Range") String l=c.getString(c.getColumnIndex("author"));
return l;
}
public void update(String s4, String s5) {
SQLiteDatabasedb = this.getWritableDatabase();
ContentValues values = new ContentValues();
values.put("author", s5); // Update the "author" column
int rowsAffected = db.update("bookinsert", values, "BookName=?", new
String[]{s4});
if (rowsAffected> 0) {
// The update was successful
} else {
// No record with the specified BookName was found
}
db.close();
}
public void delete(String s6) {
SQLiteDatabasedb = this.getWritableDatabase();
int rowsAffected = db.delete("bookinsert", "BookName=?", new
String[]{s6});
if (rowsAffected> 0) {
// The update was successful
} else {
// No record with the specified BookName was found
}

db.close();
}
}