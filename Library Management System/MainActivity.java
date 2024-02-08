package com.example.librarymgmtsystem;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.librarymgmtsystem.DB;
public class MainActivity extends AppCompatActivity {
EditTexteditText;
EditText editText1;
EditText editText2;
EditText editText3;
EditText editText4;
EditText editText6;
Button b;
Button b1;
Button b2;
Button b4;
Button b6;
Button b7;
Button b8;
TextViewtextView;
String s,s1,s3,s4,s5,s6;
int available=1000;

int issued=300;
DB db;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
editText=findViewById(R.id.editTextTextPersonName);
editText1=findViewById(R.id.editTextTextPersonName2);
editText2=findViewById(R.id.editTextTextPersonName3);
editText3=findViewById(R.id.editTextTextPersonName4);
editText4=findViewById(R.id.editTextTextPersonName5);
editText6=findViewById(R.id.editTextTextPersonName6);
b=findViewById(R.id.button);
b1=findViewById(R.id.button2);
b2=findViewById(R.id.button3);
b7=findViewById(R.id.button7);
b8=findViewById(R.id.button8);
textView=findViewById(R.id.textView);
db=new DB(MainActivity.this);
}
public void sav(View view) {
s=editText.getText().toString();
s1=editText1.getText().toString();
db.sav(s,s1);
Toast.makeText(this,"Successfully Added Book details!",
Toast.LENGTH_LONG).show();
}
public void retrieve(View view) {
s3=editText2.getText().toString();
String loc=db.retrieve(s3);
textView.setText(loc);
}
public void update(View view){
s4=editText3.getText().toString();
s5=editText4.getText().toString();
db.update(s4,s5);
Toast.makeText(this,"Successfully Updated Book details!",
Toast.LENGTH_LONG).show();
}
public void delete(View view) {
s6 = editText6.getText().toString().trim();
db.delete(s6);
Toast.makeText(this,"Successfully deleted Book details!",
Toast.LENGTH_LONG).show();

db.close();
}
public void returnbook(View view) {
available++;
issued--;
String str = "Avaliable Books: " + available + "\nIssued Books: "+issued;
Toast.makeText(this,str, Toast.LENGTH_LONG).show();
}
public void borrow(View view) {
available--;
issued++;
String str = "Avaliable Books: " + available + "\nIssued Books: "+issued;
Toast.makeText(this,str, Toast.LENGTH_LONG).show();
}
}