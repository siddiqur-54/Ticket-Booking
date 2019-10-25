package com.example.ticketbookingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BookingPage extends AppCompatActivity implements View.OnClickListener {
    private Button routebutton,bookingbutton,infobutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_page);

        routebutton = (Button)findViewById(R.id.routebuttonId);
        bookingbutton = (Button)findViewById(R.id.bookingbuttonId);


        routebutton.setOnClickListener(this);
        bookingbutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
       if(view.getId()==R.id.routebuttonId)
       {
           Intent intent=new Intent(BookingPage.this,RouteInfoActivity.class);
           startActivity(intent);

       }
       else if(view.getId()==R.id.bookingbuttonId)
       {
           Intent intent=new Intent(BookingPage.this,TicketBookingActivity.class);
           startActivity(intent);

       }

    }
}
