package com.example.assignmentandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login,toReg; EditText username,password;dbHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding
        login = findViewById(R.id.LoginBtn);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

       String userName = username.getText().toString();
       String passWord = password.getText().toString();
        DB=new dbHelper(this);


        //To register page

        toReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });

       //setting button to a click listener
       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //check if username not equal to null
               if(userName.equals("") && passWord.equals("")) {
                   Toast.makeText(getApplicationContext(), "Username and Password should not be empty", Toast.LENGTH_SHORT).show();
               } else{
                   //check from the database
                   Boolean checkUser = DB.checkUser(userName,passWord);

                   if(checkUser == true) {
                       Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                      //Direct to Home
                       Intent intent = new Intent(getApplicationContext(),Home.class);
                       startActivity(intent);
                   }else{
                       Toast.makeText(getApplicationContext(), "Failed,Check details", Toast.LENGTH_SHORT).show();
                   }

               }

           }
       });

    }
}