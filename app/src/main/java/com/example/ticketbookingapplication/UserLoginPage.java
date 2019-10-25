package com.example.ticketbookingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLoginPage extends AppCompatActivity implements View.OnClickListener {

    Sqldatabasehelper databasehelper;

    private EditText Username,Password;
    private Button loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login_page2);

        databasehelper = new Sqldatabasehelper(this);

        Username=(EditText)findViewById(R.id.UserNameId);
        Password=(EditText)findViewById(R.id.UserPasswordID);

        loginbutton=(Button)findViewById(R.id.UserLoginId);

        loginbutton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        String UN=Username.getText().toString();
        String PW=Password.getText().toString();


        if(view.getId()==R.id.UserLoginId)
        {
            Boolean result = databasehelper.find(UN,PW);




            if(result==true)
            {
               
                Intent intent= new Intent(UserLoginPage.this,BookingPage.class);

                startActivity(intent);

            }
            else
            {
                Toast.makeText(getApplicationContext(),"Login error! Try again:)",Toast.LENGTH_LONG).show();
            }

        }


    }

}
