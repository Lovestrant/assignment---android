package com.example.assignmentandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
   //EditText fullname, password, address, idNumber,username,gender;dbHelper DB;
    EditText password,username;dbHelper DB;
    Button register,toLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //binding
      // fullname = findViewById(R.id.fullName);
        password = findViewById(R.id.password);
//        address = findViewById(R.id.adress);
//        idNumber = findViewById(R.id.idNumber);
        username = findViewById(R.id.username);
//        gender = findViewById(R.id.gender);
//        toLogin = findViewById(R.id.toLogin);
//        register = findViewById(R.id.register);

        //Getting texts
       // String fullName = fullname.getText().toString();
        String pass = password.getText().toString();
       // String TheAddress = address.getText().toString();
        String userName = username.getText().toString();
       // String Gender = gender.getText().toString();
        //int idNum = Integer.parseInt(idNumber.getText().toString());

        DB=new dbHelper(this);
        //add on click event listener
        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get Db
            Boolean CheckInsertData = DB.insertuserdata(userName,pass);

            if(CheckInsertData == true) {
                Toast.makeText(getApplicationContext(), "Registration Success", Toast.LENGTH_SHORT).show();
                //Intent to Login page
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
            }
        });


    }
}