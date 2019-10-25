package com.example.ticketbookingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class TicketBookingActivity extends AppCompatActivity implements View.OnClickListener {

    BookingDetails bookingDetails;
    SqlDatabaseBooking bookingHelper;
    String[] from,to,date,time,busname,person,type;
    private Button confirm;
    private Spinner from1,to1,time1,busname1,person1,type1 ;
    private EditText date1,name,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_booking);

        bookingHelper=new SqlDatabaseBooking(this);
        bookingDetails=new BookingDetails();

        from = getResources().getStringArray(R.array.From);
        to = getResources().getStringArray(R.array.To);
        date = getResources().getStringArray(R.array.Date);
        time = getResources().getStringArray(R.array.Time);
        busname = getResources().getStringArray(R.array.Busname);
        person = getResources().getStringArray(R.array.Person);
        type = getResources().getStringArray(R.array.bustype);


        from1 = (Spinner)findViewById(R.id.departuresId);
        to1 = (Spinner)findViewById(R.id.destinationsId);

        date1 = (EditText)findViewById(R.id.editTextDateId);
        name = (EditText)findViewById(R.id.editTextNameId);
        phone = (EditText)findViewById(R.id.editTextPhoneId);

        time1 = (Spinner)findViewById(R.id.timesId);
        busname1 = (Spinner)findViewById(R.id.buschoosesId);
        person1 = (Spinner)findViewById(R.id.personsId);
        type1 = (Spinner)findViewById(R.id.bustypesId);





        confirm = (Button)findViewById(R.id.confirmbuttonId);
        confirm.setOnClickListener(this);

        ArrayAdapter<String> adapterfrom = new ArrayAdapter<String>(this,R.layout.sampleview,R.id.textviewsampleid,from);
        from1.setAdapter(adapterfrom);

        ArrayAdapter<String> adapterto = new ArrayAdapter<String>(this,R.layout.sampleview,R.id.textviewsample2id,to);
        to1.setAdapter(adapterto);

        ArrayAdapter<String> adaptertime = new ArrayAdapter<String>(this,R.layout.sampleview,R.id.textviewsample3id,time);
        time1.setAdapter(adaptertime);

        ArrayAdapter<String> adapterbus = new ArrayAdapter<String>(this,R.layout.sampleview,R.id.textviewsample4id,busname);
        busname1.setAdapter(adapterbus);

        ArrayAdapter<String> adapterperson = new ArrayAdapter<String>(this,R.layout.sampleview,R.id.textviewsample5id,person);
        person1.setAdapter(adapterperson);

        ArrayAdapter<String> adaptertype = new ArrayAdapter<String>(this,R.layout.sampleview,R.id.textviewsample6id,type);
        type1.setAdapter(adaptertype);

    }

    @Override
    public void onClick(View view) {

        String From = from1.getSelectedItem().toString();
        String To = to1.getSelectedItem().toString();

        String Date = date1.getText().toString();
        String Name = name.getText().toString();
        String Phone = phone.getText().toString();

        String Time = time1.getSelectedItem().toString();
        String Busname = busname1.getSelectedItem().toString();
        String Person = person1.getSelectedItem().toString();
        String Type = type1.getSelectedItem().toString();

        /*Toast.makeText(getApplicationContext(),From,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),To,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),Date,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),Time,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),Busname,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),Person,Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),Type,Toast.LENGTH_LONG).show();*/



        if(view.getId()==R.id.confirmbuttonId)
        {
            bookingDetails.setName(Name);
            bookingDetails.setPhone(Phone);
            bookingDetails.setFrom(From);
            bookingDetails.setTo(To);
            bookingDetails.setDate(Date);
            bookingDetails.setTime(Time);
            bookingDetails.setBusname(Busname);
            bookingDetails.setPerson(Person);
            bookingDetails.setBustype(Type);

            long rowId= bookingHelper.insertdata(bookingDetails);

            if (rowId>0)
            {
                Toast.makeText(getApplicationContext(),"Insertion Successful :)",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(TicketBookingActivity.this,InfoActivity.class);

                intent.putExtra("name",Name);
                intent.putExtra("phone",Phone);

                intent.putExtra("date",Date);

                intent.putExtra("from",From);
                intent.putExtra("to",To);

                intent.putExtra("time",Time);
                intent.putExtra("busname",Busname);
                intent.putExtra("person",Person);
                intent.putExtra("type",Type);

                startActivity(intent);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Insertion failed ;( ",Toast.LENGTH_LONG).show();
            }



        }
    }
}
