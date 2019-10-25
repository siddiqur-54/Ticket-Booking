package com.example.ticketbookingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.PriorityQueue;

public class Admin extends AppCompatActivity implements View.OnClickListener {
    private EditText UserName,Password;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        UserName=(EditText)findViewById(R.id.editText1);
        Password=(EditText)findViewById(R.id.editText2);

        Login=(Button)findViewById(R.id.button1);
        Login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String u=UserName.getText().toString();
        String p=Password.getText().toString();

        if (u.equals("ADMIN") && (p.equals("1234")) )
        {
            Toast.makeText(getApplicationContext(),"You have successfully logged in",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(Admin.this,Information.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Wrong username or password",Toast.LENGTH_LONG).show();
        }

    }
}
