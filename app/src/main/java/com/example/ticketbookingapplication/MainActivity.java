package com.example.ticketbookingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button admin,user,add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        admin=(Button)findViewById(R.id.adminbuttonid);
        user=(Button)findViewById(R.id.userbuttonid);
        add=(Button)findViewById(R.id.addnewbuttonid);

        admin.setOnClickListener(this);
        user.setOnClickListener(this);
        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.adminbuttonid)
        {
            Intent intent=new Intent(MainActivity.this,Admin.class);
            startActivity(intent);
        }
        else if (view.getId()==R.id.userbuttonid)
        {
            Intent intent=new Intent(MainActivity.this,UserLoginPage.class);
            startActivity(intent);
        }
        else
        {
            Intent intent=new Intent(MainActivity.this,Registration.class);
            startActivity(intent);
        }

    }
}
