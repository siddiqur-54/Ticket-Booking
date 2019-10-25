package com.example.ticketbookingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Information extends AppCompatActivity implements View.OnClickListener {

    private Button information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        information=(Button)findViewById(R.id.informationbuttonid);

        information.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.informationbuttonid)
        {
            Intent intent=new Intent(Information.this,Passengers.class);
            startActivity(intent);
        }

    }
}
