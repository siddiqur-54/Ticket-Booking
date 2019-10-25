package com.example.ticketbookingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {
private TextView T1,T2,T3,T4,T5,T6,T7,T8,T9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        T1=(TextView)findViewById(R.id.text1);
        T2=(TextView)findViewById(R.id.text2);
        T3=(TextView)findViewById(R.id.text3);
        T4=(TextView)findViewById(R.id.text4);
        T5=(TextView)findViewById(R.id.text5);
        T6=(TextView)findViewById(R.id.text6);
        T7=(TextView)findViewById(R.id.text7);
        T8=(TextView)findViewById(R.id.text8);
        T9=(TextView)findViewById(R.id.text9);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            String name=bundle.getString("name");
            String phone=bundle.getString("phone");
            String from=bundle.getString("from");
            String to=bundle.getString("to");
            String date=bundle.getString("date");
            String time=bundle.getString("time");
            String busname=bundle.getString("busname");
            String person=bundle.getString("person");
            String type=bundle.getString("type");
            T9.setText("NAME : "+name);
            T8.setText("MOBILE : "+phone);
            T1.setText("FROM : "+from);
            T2.setText("TO : "+to);
            T3.setText("DATE : "+date);
            T4.setText("TIME : "+time);
            T5.setText("BUS NAME : "+busname);
            T6.setText("PERSON : "+person);
            T7.setText("TYPE : "+type);
        }
    }
}
