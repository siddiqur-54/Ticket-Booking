package com.example.ticketbookingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Passengers extends AppCompatActivity {
    private ListView listView;
    SqlDatabaseBooking databasehelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passengers);


        listView=(ListView)findViewById(R.id.ListViewID);

        databasehelper=new SqlDatabaseBooking(this);
        loadData();
    }
    public void loadData()
    {
        ArrayList<String>listdata=new ArrayList<>();

        Cursor cursor=databasehelper.showData();
        if (cursor.getCount()==0)
        {
            Toast.makeText(getApplicationContext(),"No data found",Toast.LENGTH_LONG).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                listdata.add("Name : "+cursor.getString(1)+"\nMobile : "+cursor.getString(2)+"\nFROM : "+cursor.getString(3)+"\nTO : "+cursor.getString(4)+"\nDATE : "+cursor.getString(5)+"\nTIME : "+cursor.getString(6)+"\nBUS NAME : "+cursor.getString(7)+"\nPERSON : "+cursor.getString(8)+"\nBUS TYPE : "+cursor.getString(9));
            }
        }
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this,R.layout.list_item,R.id.DetailsTextViewId,listdata);
        listView.setAdapter(adapter);
    }
}
