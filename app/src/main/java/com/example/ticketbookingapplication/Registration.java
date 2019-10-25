package com.example.ticketbookingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity implements View.OnClickListener{
    private EditText name,phone,email,username,password;
    private Button signup;

    UserDetails userDetails;
    Sqldatabasehelper databasehelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = (EditText)findViewById(R.id.NameId);
        phone = (EditText) findViewById(R.id.PhoneId);
        email = (EditText) findViewById(R.id.EmailId);
        username = (EditText) findViewById(R.id.username2Id);
        password = (EditText) findViewById(R.id.UserPasswordID);

        signup = (Button) findViewById(R.id.regId);

        databasehelper = new Sqldatabasehelper(this);
        userDetails = new UserDetails();

        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String Name = name.getText().toString();
        String Phone = phone.getText().toString();
        String Email = email.getText().toString();
        String UserName = username.getText().toString();
        String Password = password.getText().toString();

        if(view.getId()==R.id.regId)
        {
            if(!Name.equals("") && !Phone.equals("") && !Email.equals("") && !UserName.equals("") && !Password.equals(""))
            {
                userDetails.setName(Name);
                userDetails.setPhone(Phone);
                userDetails.setEmail(Email);
                userDetails.setUsername(UserName);
                userDetails.setPassword(Password);

                long rowId= databasehelper.insertdata(userDetails);

                if (rowId>0)
                {
                    Toast.makeText(getApplicationContext(),"Insertion Successful :)",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Insertion failed ;( ",Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Please Enter All the Data ",Toast.LENGTH_LONG).show();
            }
        }

    }
}
